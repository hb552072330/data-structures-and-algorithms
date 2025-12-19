package cn.baymax.example.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhanghongbing
 * @data 2021/11/26
 */
public class ComparatorReturn {
    public static void main(String[] args) {
        List<UserModel> list = new ArrayList<UserModel>() {{
            add(new UserModel(33));
            add(new UserModel(32));
            add(new UserModel(13));
            add(new UserModel(23));
            add(new UserModel(5));
        }};
        System.out.println(list);
        Collections.sort(list, new Comparator<UserModel>() {
            @Override
            public int compare(UserModel model0, UserModel model1) {
                return model0.getId().compareTo(model1.getId());    // 升序 返回值必须是-1 0 1 这三个；如果只返回其中两个肯能会排序失效
            }
        });
        System.out.println(list);
    }
}

class UserModel {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserModel(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}