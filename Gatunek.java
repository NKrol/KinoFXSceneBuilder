enum Gatunek{
        Dramat("Dramat"),
        Horror("Horror"),
        Akcja("Akcja"),
        Komedia("Komedia");

        private Gatunek(String desc){
            this.desc = desc;
        }
        public String getDesc(){
            return desc;
        }

        private final String desc;

        public static Gatunek fromDesc(String desc) {
        Gatunek[] values = values();
        for (Gatunek gatunek : values) {
            if (gatunek.getDesc().equals(desc))
                return gatunek;
        }
        return null;
    }
}
