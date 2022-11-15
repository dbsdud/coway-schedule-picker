package io.dbsdud.schedulepicker.product.data.entity;

import lombok.Getter;

@Getter
public enum ProductType {
    WATER_PURIFIER("정수기") { // 정수기
        @Override
        public String toString() {
            return "WATER_PURIFIER";
        }
    },
    BIDET("비데") { // 비데
        @Override
        public String toString() {
            return "BIDET";
        }
    },
    MATTRESS("매트리스") { // 매트리스
        @Override
        public String toString() {
            return "MATTRESS";
        }
    },
    AIR_CLEANER("공기청정기") { // 공기청정기
        @Override
        public String toString() {
            return "AIR_CLEANER";
        }
    };

    private final String type1Value;

    ProductType(String type1Value) {
        this.type1Value = type1Value;
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
