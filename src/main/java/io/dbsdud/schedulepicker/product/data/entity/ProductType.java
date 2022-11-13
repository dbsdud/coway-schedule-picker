package io.dbsdud.schedulepicker.product.data.entity;

public enum ProductType {

    WATER_PURIFIER { // 정수기
        @Override
        public String toString() {
            return "WATER_PURIFIER";
        }
    },
    BIDET { // 비데
        @Override
        public String toString() {
            return "BIDET";
        }
    },
    MATTRESS { // 매트리스
        @Override
        public String toString() {
            return "MATTRESS";
        }
    },
    AIR_CLEANER { // 공기청정기
        @Override
        public String toString() {
            return "AIR_CLEANER";
        }
    }
}
