package com.example.nice.internetrequest;

import java.util.List;

/**
 * Created by walter on 2017/5/17.
 */

public class SearchBean {

    /**
     * success : true
     * message :
     * data : [{"id":2,"agUserId":"5204092642","name":"hh","phone":"13188549113","money":1},{"id":2,"agUserId":"5204092642","name":"1","phone":"18642943884","money":188},{"id":2,"agUserId":"5204092642","name":"的","phone":"18642943886","money":1},{"id":2,"agUserId":"5204092642","name":"啊啊啊啊啊啊啊 啊啊啊啊啊啊啊啊啊啊啊啊啊啊 啊啊啊啊啊啊啊啊啊啊啊 啊啊啊啊啊啊啊 啊啊 啊啊 啊","phone":"15040403271","money":10000},{"id":2,"agUserId":"5204092642","name":"啊啊啊啊啊啊啊 啊啊啊啊啊啊啊啊啊啊啊啊啊啊 啊啊啊啊啊啊啊啊啊啊啊 啊啊啊啊啊啊啊 啊啊 啊啊 啊","phone":"15040403271","money":100},{"id":2,"agUserId":"5204092642","name":"啊啊啊啊啊啊啊 啊啊啊啊啊啊啊啊啊啊啊啊啊啊 啊啊啊啊啊啊啊啊啊啊啊 啊啊啊啊啊啊啊 啊啊 啊啊 啊","phone":"15040403271","money":100.55},{"id":2,"agUserId":"5204092642","name":"q","phone":"18642943886","money":11},{"id":2,"agUserId":"5204092642","name":"","phone":"","money":""},{"id":2,"agUserId":"5204092642","name":"q","phone":"18642943886","money":11},{"id":2,"agUserId":"5204092642","name":"123","phone":"12","money":1}]
     */

    private boolean success;
    private String message;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2
         * agUserId : 5204092642
         * name : hh
         * phone : 13188549113
         * money : 1.0
         */

        private String id;
        private String agUserId;
        private String name;
        private String phone;
        private String money;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAgUserId() {
            return agUserId;
        }

        public void setAgUserId(String agUserId) {
            this.agUserId = agUserId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }
    }
}
