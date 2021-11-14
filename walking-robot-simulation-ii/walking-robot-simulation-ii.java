class Robot {

    int w, h, x, y;
    String dir;
    public Robot(int width, int height) {
        w= width;
        h =height;
        x=0;
        y=0;
        dir = "East";
    }
    
    public void move(int num) {
        num = num%(2*w + 2*h-4);
        if(num==0)
            num = 2*w + 2*h-4;
        
        for(int i=0;i<num;i++){
            switch(dir){
                case "East":
                    if(x==w-1){
                        y++;
                        dir = "North";
                    }
                    else
                        x++;
                    break;
                    
                case "North":
                    if(y==h-1){
                        x--;
                        dir = "West";
                    }
                    else
                        y++;
                    break;
                   
                case "West":
                    if(x==0){
                        y--;
                        dir ="South";
                    }
                    else
                        x--;
                    break;
                case "South":
                    if(y==0){
                        x++;
                        dir="East";
                        
                    }
                    else
                        y--;
                    
            }
        }
    }
    
    public int[] getPos() {
        
        return new int[]{x,y};
    }
    
    public String getDir() {
        return dir;
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.move(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */