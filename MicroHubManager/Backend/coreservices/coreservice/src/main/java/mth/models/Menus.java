package mth.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="menus")
public class Menus {
    @Id
    Long mid;
    String menu;

    @Override
    public String toString() {
        return "Menus{" +
                "mid=" + mid +
                ", menu='" + menu + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    String icon;
}
