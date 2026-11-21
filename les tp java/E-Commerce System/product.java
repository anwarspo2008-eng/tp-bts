public abstract class product  implements discountable ,Comparable<product>
{
        String      id;
        String      name;
        int         price;

        public product(String id,   String name,    int price )
        {
            this.id  = id;
            this.name = name;
            this.price =  price;
        }
        
        public String getid()
        {
            return id;
        }
        public String getname()
        {
            return name;
        }
        public int getprice()
        {
            return price;
        }
        //setters and getters
        public void setid(String nid)
        {
            this.id = nid;
        }
        public void setname(String nname)
        {
            this.name = nname;
        }
        public void setprice(int nprice)
        {
            this.price = nprice;
        }

        //overided methodes

        @Override
        public String toString()
        {
            return "[id = " + id + ", name = " + name + ", price = " + price + "]";
        }
        @Override
        public boolean equals(Object obj){
            if((obj == null) || !(obj instanceof product)) return false;
            product c = (product) obj;
            return this.id.equalsIgnoreCase(c.id);
            }

        @Override
        public int compareTo(product o) {
        return Double.compare(this.price, o.price);
        }
        

}
