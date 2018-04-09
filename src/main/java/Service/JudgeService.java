package Service;

import dao.ScoreDao;
import factory.DaoFactory;
import org.apache.commons.beanutils.BeanUtils;
import po.ScorePo;
import vo.ScoreVo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class JudgeService
{
    /**
     * 添加分数记录
     *
     * @param vo
     * @return
     */
    public boolean AddScore(ScoreVo vo)
    {
        ScoreDao dao = DaoFactory.getScroeDao();
        ScorePo po = new ScorePo();
        try
        {
            BeanUtils.copyProperties(po, vo);
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        dao.save(po);
        return true;
    }


    /**
     * 取得个人单项的所有分数
     *
     * @return
     */
    public List<ScoreVo> getScore(String gameID,String playerID)
    {
        ScoreDao dao = DaoFactory.getScroeDao();
        List<ScorePo> pos = dao.getAllScoreList();
        List<ScoreVo> vos = new ArrayList<ScoreVo>();
        for (ScorePo po : pos)
        {
            try
            {
                //TODO 该用hql语句的
                if (po.getMatchId().equals(gameID)&&po.getPlayerId().equals(playerID))
                {
                    ScoreVo vo = new ScoreVo();
                    BeanUtils.copyProperties(vo, po);
                    vos.add(vo);
                }
            } catch (IllegalAccessException e)
            {
                e.printStackTrace();
            } catch (InvocationTargetException e)
            {
                e.printStackTrace();
            }
        }
        return vos;
    }

    /**
     * 取得所有打分信息
     *
     * @return
     */
    public List<ScoreVo> getAllSroce()
    {
        ScoreDao dao = DaoFactory.getScroeDao();
        List<ScorePo> pos = dao.getAllScoreList();
        List<ScoreVo> vos = new ArrayList<ScoreVo>();
        for (ScorePo po : pos)
        {
            try
            {
                ScoreVo vo = new ScoreVo();
                BeanUtils.copyProperties(vo, po);
                vos.add(vo);
            } catch (IllegalAccessException e)
            {
                e.printStackTrace();
            } catch (InvocationTargetException e)
            {
                e.printStackTrace();
            }
        }
        return vos;
    }

    /**
     * 总裁判确认该分数无误
     *
     * @param vo
     * @return
     */
    public boolean checkScore(ScoreVo vo)
    {
        vo.setScoreAccept("接受");
        ScoreDao dao = DaoFactory.getScroeDao();
        ScorePo po = new ScorePo();
        try
        {
            BeanUtils.copyProperties(po, vo);
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        dao.update(po);
        return true;
    }


    /**
     * 计算个人单项成绩
     * @param D 奖励分
     * @param P 惩罚分
     * @return
     */
    public double getResult(double D,Double P,String gameID,String playerID)
    {
        List<ScoreVo> list = getScore(gameID, playerID);

        //TODO 分数暂定百分制  总成绩=去掉最高分和最低分的平均分*裁判数+D-P（精确度，分值范围）
        //因为比赛最多有5个裁判
        double maxNum=list.get(0).getScore();
        double minNum=list.get(0).getScore();
        double result=0;
        for (ScoreVo vo:list)
        {
            result+=vo.getScore();
        }
        result-=maxNum;
        result-=minNum;
        result=(result/(list.size()-2))+D-P;
        System.out.println("成绩是:"+result);
        return result;
    }

}