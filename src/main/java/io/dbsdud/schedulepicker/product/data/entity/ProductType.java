package io.dbsdud.schedulepicker.product.data.entity;

import lombok.Getter;

@Getter
public enum ProductType {
    WATER_PURIFIER("정수기", 0) { // 정수기
        @Override
        public String toString() {
            return "WATER_PURIFIER";
        }
    },
    BIDET("비데", 1) { // 비데
        @Override
        public String toString() {
            return "BIDET";
        }
    },
    MATTRESS("매트리스", 2) { // 매트리스
        @Override
        public String toString() {
            return "MATTRESS";
        }
    },
    AIR_CLEANER("공기청정기", 3) { // 공기청정기
        @Override
        public String toString() {
            return "AIR_CLEANER";
        }
    };

    private final String type1Value;
    private final int type2Value;

    ProductType(String type1Value, int type2Value) {

        this.type1Value = type1Value;
        this.type2Value = type2Value;
    }
//    WATER_PURIFIER { // 정수기
//        @Override
//        public String toString() {
//            return "WATER_PURIFIER";
//        }
//    },
//    BIDET { // 비데
//        @Override
//        public String toString() {
//            return "BIDET";
//        }
//    },
//    MATTRESS { // 매트리스
//        @Override
//        public String toString() {
//            return "MATTRESS";
//        }
//    },
//    AIR_CLEANER { // 공기청정기
//        @Override
//        public String toString() {
//            return "AIR_CLEANER";
//        }
//    };
}
