package Service;

import org.junit.Test;
import vo.ScoreVo;

import java.util.List;

import static org.junit.Assert.*;

public class JudgeServiceTest
{

    @Test
    public void addScore()
    {
        ScoreVo vo=new ScoreVo();

        JudgeService service=new JudgeService();
        List<ScoreVo> list = service.getAllSroce();
        service.getResult(0.0,0.0,"DG","112");
    }

    @Test
    public void setPlayerScore()
    {
        JudgeService service=new JudgeService();
        service.setPlayerScore("112");
    }
}