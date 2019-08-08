package ara.seleniumassingment.seleniumassisgnment;
 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
 
public class Unzip2 {
 
       public static void main(String[] args) throws IOException {
              
              String zipFilePath = "C:\\SELENIUM\\readfile";
        
        String destDir = "C:\\SELENIUM\\readfile\\UZFile";
        String zipFilePathWithName;
        File file1=new File(zipFilePath);
             
             String filenames="";
                     String[] filelist=file1.list();
                     
                           for (String filename: filelist) {
                                  System.out.println(filename);
                                  
                                  if(filename.contains(".zip"))
                                  {
                                         zipFilePathWithName=zipFilePath+filename;
                                         
                                         filenames=filenames+","+filename;
                                  
                                  unzip(zipFilePathWithName, destDir);
                                  
                                  }        
 
                           }
                                      //          System.out.println(textfile (filenames));
       }
 
       private static void unzip(String zipFilePath, String destDir) {
        File dir = new File(destDir);
        
        if(!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while(ze != null){
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());
               
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
                }
                fos.close();
                
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
        
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
 
        
    }
       /*public static String textfile(String text) throws IOException {
              BufferedWriter output= null;
              
              try {
                     File file=new File("D:/Zfile/Mapped_Coupons");
                     output = new BufferedWriter(new FileWriter(file));
                     output.write(text);
                     
              }
              
              catch(IOException e) {
                     e.printStackTrace();
              }
              finally {
                     if(output!=null) {
                           output.close();
                           System.out.println(output);
                     }
              }
              return text ;
       }*/
 
}
