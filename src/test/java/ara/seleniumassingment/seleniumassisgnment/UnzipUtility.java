package ara.seleniumassingment.seleniumassisgnment;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
 
public class UnzipUtility {
	//unzip Multiple files
	/**
     * Size of the buffer to read/write data
     */
    private static final int BUFFER_SIZE = 4096;
    /**
     * Extracts a zip file specified by the zipFilePath to a directory specified by
     * destDirectory (will be created if does not exists)
     * @param zipFilePath
     * @param destDirectory
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
    String zipFilePath="C:\\SELENIUM\\readfile";
    String destDirectory ="C:\\SELENIUM\\readfile\\UZFile";
    String zipFilePathWithName;
    File file1=new File(zipFilePath);
    
    String  Zipfilename;
    String filenames="";
            String[] filelist=file1.list();
            
                  for (String filename: filelist) {
                         System.out.println(filename);
                        // System.out.println("-------"+filelist.length);
                         
						if(filename.contains(".zip")) {
							
							String zipFilePath1=zipFilePath+"\\"+filename;
							String destDirectory1 =destDirectory+filename+"\\";
							
                        
                        	 
                        	 System.out.println("********file name contains .zip********"+filename.contains(".zip"));
                        	 
                        	 try {
                        		 
                        		 UnzipUtility unzipper = new UnzipUtility();
                        		 unzipper.unzip(zipFilePath1, destDirectory1);
                             } catch (Exception ex) {
                                 // some errors occurred
                                 ex.printStackTrace();
                             }
                        	 /*zipFilePathWithName=zipFilePath+filename;
                                
                                filenames=filenames+","+filename;
                         
                         unzip(zipFilePathWithName, destDirectory);
                         */
                          
						}
                  }
    }
   
	public static void unzip(String zipFilePath1, String destDirectory1) throws IOException {
        File destDir = new File(destDirectory1);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath1));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        while (entry != null) {
            String filePath = destDirectory1 + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                extractFile(zipIn, filePath);
            } else {
                // if the entry is a directory, make the directory
                File dir = new File(filePath);
                dir.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }
    /**
     * Extracts a zip entry (file entry)
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
}
