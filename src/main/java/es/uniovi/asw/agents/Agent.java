package es.uniovi.asw.agents;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author Roberto. Class use to represent the citizens and parse their data.
 */
public class Agent {

    private String name;
	private String email;
	private String location;
	private String ID;
	private String password;
	private int kind;

	public Agent(String name, String location, String email, String ID, int kind)
    {
        this.name = name;
        this.location = location;
        this.email = email;
        this.ID = ID;
        this.kind = kind;
    }


    public Agent(String name, String email, String ID, int kind) {

        this.name = name;
        this.location = null;
        this.email = email;
        this.ID = ID;
        this.kind = kind;
    }

    public Agent(String[] data) {
        this.name = data[0];
        this.location = data[1];
        this.email = data[2];
        this.ID = data[3];
        this.kind = Integer.parseInt(data[4]);

    }

    public Agent(String name, String location, String email, String ID, int kind, String password)
    {
        this(name, location, email, ID, kind);
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agent agent = (Agent) o;

        if (kind != agent.kind) return false;
        if (name != null ? !name.equals(agent.name) : agent.name != null) return false;
        if (email != null ? !email.equals(agent.email) : agent.email != null) return false;
        if (location != null ? !location.equals(agent.location) : agent.location != null) return false;
        if (ID != null ? !ID.equals(agent.ID) : agent.ID != null) return false;
        return password != null ? password.equals(agent.password) : agent.password == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (ID != null ? ID.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + kind;
        return result;
    }

    @Override
    public String toString() {
        return "Agent [" +
                "name=" + name +
                ", email=" + email  +
                ", location=" + location  +
                ", ID=" + ID +
                ", kind=" + kind +
                ']';
    }
}
