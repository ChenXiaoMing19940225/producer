package com.cxm.optimization.enumclass;

public enum enumclass implements interfaceclass {

    ANIMAL{
        @Override
        public String eat() {
           return  "this is Aminal";
        }
    },
    PEOPLE{
        @Override
        public String eat() {
            return  "this is PEOPLE";
        }
    },
    SEAANIMAL{
        @Override
        public String eat() {
            return  "SEAANIMAL";
        }
    };


    @Override
    public String eat() {
      return "吃的是海洋生物";
    }
}
