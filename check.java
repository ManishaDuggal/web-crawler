import java.io.*;
import java.util.*; 
import java.lang.*; 
class check{
    public static void main(String[] args) throws IOException {
        if(args.length==3){
            check_url(args[0]);
            check_depth(Integer.parseInt(args[1]));
            check_dir(args[2]);
        }
    
    
    fetchpage();
    System.out.println("not exit 0");
   }
   public static void check_depth(int d){
       if(d<0){
           System.out.println("Invalid Depth");
           System.exit(0);
       }
       if(d>10){
        System.out.println("Depth is out of range");
        System.exit(0);
       }
   }
public static void check_dir(String path){
    File dir=new File(path);
    boolean b=dir.isDirectory();
    if(b==false){
        System.out.println("no its not a directory");
        System.exit(0);
    }
    b=dir.canWrite();
    if(b){
        System.out.println("yes it is writable");
    }
}
public static void check_url(String url){

    String command=new String("wget --no-check-certificate --spider ");
    command=command+url;
    
    StringBuffer output = new StringBuffer();
    
            Process p;
    
            try {
                p = Runtime.getRuntime().exec(command);
                int r=p.waitFor();
                BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
    
                            String line = "";			
                while ((line = reader.readLine())!= null) {
                    output.append(line + "\n");
                }
                if(r!=0){
                System.out.println("url is not ok");
                System.exit(0);
                }
                else
                System.out.println("url is ok");
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
      
    
    }
    public static void fetchpage() throws IOException{
        File file=new File("temp.txt");
        
        if(file.exists()){
            file.delete();
            file.createNewFile();
        }else{
            file.createNewFile();
        }
        if(file.exists()){
            System.out.println("Fetching page...");
            StringBuffer output = new StringBuffer();
        
                Process p;
        
                try {
                    p = Runtime.getRuntime().exec("wget --no-check-certificate -O temp.txt https://www.chitkara.edu.in/");
                    p.waitFor();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
        
                                String line = "";			
                    while ((line = reader.readLine())!= null) {
                        output.append(line + "\n");
                    }
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }

    }

   }
}
