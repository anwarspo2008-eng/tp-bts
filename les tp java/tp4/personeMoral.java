public class personMoral extends client{
        private String numContract;

        public personMoral(int num , String email , String nom){
            super(num , email ,nom );
        }
        @Overide
        public String toString(){
            return super.toString() + "N-contract : " +numContract;
        }

}

