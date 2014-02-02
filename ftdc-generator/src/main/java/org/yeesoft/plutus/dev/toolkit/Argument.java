package org.yeesoft.plutus.dev.toolkit;

/**
 * plutus
 * Written by Yee at 13-11-18 下午3:35
 */
public class Argument {
        private String type;
        private String name;

        String getType() {
            return type;
        }

        void setType(String type) {
            this.type = type;
        }

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = Utils.trimSymbol(name);
        }

        @Override
        public String toString() {
            return "type: " + type + " name: " + name;
        }
}
