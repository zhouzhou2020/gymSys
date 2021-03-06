package po;

import javax.persistence.*;

@Entity
@Table(name = "match", schema = "gaysys", catalog = "")
public class MatchPo
{
    private String matchId;
    private String playerGroup;
    private String event;
    private String chiefId;
    private String satrtTime;
    private String endTime;
    private String matchStatus;
    private Integer matchType;
    private String subGroup;

    @Id
    @Column(name = "MatchID", nullable = false, length = 255)
    public String getMatchId()
    {
        return matchId;
    }

    public void setMatchId(String matchId)
    {
        this.matchId = matchId;
    }

    @Basic
    @Column(name = "playerGroup", nullable = true, length = 255)
    public String getPlayerGroup()
    {
        return playerGroup;
    }

    public void setPlayerGroup(String playerGroup)
    {
        this.playerGroup = playerGroup;
    }

    @Basic
    @Column(name = "Event", nullable = true, length = 255)
    public String getEvent()
    {
        return event;
    }

    public void setEvent(String event)
    {
        this.event = event;
    }

    @Basic
    @Column(name = "ChiefID", nullable = true, length = 255)
    public String getChiefId()
    {
        return chiefId;
    }

    public void setChiefId(String chiefId)
    {
        this.chiefId = chiefId;
    }

    @Basic
    @Column(name = "SatrtTime", nullable = true, length = 255)
    public String getSatrtTime()
    {
        return satrtTime;
    }

    public void setSatrtTime(String satrtTime)
    {
        this.satrtTime = satrtTime;
    }

    @Basic
    @Column(name = "EndTime", nullable = true, length = 255)
    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "MatchStatus", nullable = true, length = 255)
    public String getMatchStatus()
    {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus)
    {
        this.matchStatus = matchStatus;
    }

    @Basic
    @Column(name = "MatchType", nullable = true)
    public Integer getMatchType()
    {
        return matchType;
    }

    public void setMatchType(Integer matchType)
    {
        this.matchType = matchType;
    }

    @Basic
    @Column(name = "SubGroup", nullable = true, length = 255)
    public String getSubGroup()
    {
        return subGroup;
    }

    public void setSubGroup(String subGroup)
    {
        this.subGroup = subGroup;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatchPo matchPo = (MatchPo) o;

        if (matchId != null ? !matchId.equals(matchPo.matchId) : matchPo.matchId != null) return false;
        if (playerGroup != null ? !playerGroup.equals(matchPo.playerGroup) : matchPo.playerGroup != null) return false;
        if (event != null ? !event.equals(matchPo.event) : matchPo.event != null) return false;
        if (chiefId != null ? !chiefId.equals(matchPo.chiefId) : matchPo.chiefId != null) return false;
        if (satrtTime != null ? !satrtTime.equals(matchPo.satrtTime) : matchPo.satrtTime != null) return false;
        if (endTime != null ? !endTime.equals(matchPo.endTime) : matchPo.endTime != null) return false;
        if (matchStatus != null ? !matchStatus.equals(matchPo.matchStatus) : matchPo.matchStatus != null) return false;
        if (matchType != null ? !matchType.equals(matchPo.matchType) : matchPo.matchType != null) return false;
        if (subGroup != null ? !subGroup.equals(matchPo.subGroup) : matchPo.subGroup != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = matchId != null ? matchId.hashCode() : 0;
        result = 31 * result + (playerGroup != null ? playerGroup.hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (chiefId != null ? chiefId.hashCode() : 0);
        result = 31 * result + (satrtTime != null ? satrtTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (matchStatus != null ? matchStatus.hashCode() : 0);
        result = 31 * result + (matchType != null ? matchType.hashCode() : 0);
        result = 31 * result + (subGroup != null ? subGroup.hashCode() : 0);
        return result;
    }
}
