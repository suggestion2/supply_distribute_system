package com.su.supplydistributesystem.response;

import com.sug.core.platform.web.pagination.PaginationView;
import org.springframework.beans.factory.annotation.Autowired;
import com.su.supplydistributesystem.domain.User;

import java.util.List;

public class UserListView extends PaginationView<User>{

        @Autowired
        public UserListView() {
        }

        public UserListView(List<User> list,int count) {
            this.setList(list);
            this.setCount(count);
        }

        public UserListView(List<User> list) {
            this.setList(list);
        }
}
