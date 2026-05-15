package mth.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    Long role;

    public void setRole(Long role) {
        this.role = role;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    String rolename;

    public Long getRole() {
        return role;
    }

    public String getRolename() {
        return rolename;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "role=" + role +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
