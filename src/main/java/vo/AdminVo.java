package vo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

public class AdminVo
{
    private String id;
    private String password;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
