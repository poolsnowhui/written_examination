import java.io.File;
import java.io.FileNotFoundException;

public interface VideoDownloadali {
	/**

	 * @param file 多个文件的数组 数组大小取1-n
	 * @return 文件内容分片
	 * @throws FileNotFoundException
	 */
	public File[] downMultiFile (String []file)throws FileNotFoundException;
	/**
	 * @param file 多个文件的数组 数组大小取1-n
	 * @param start 文件的开始 0-文件的字节大小，小于结尾
	 * @param end 文件的结尾 0-文件的字节大小，小大于开始
	 * @return 文件内容分片
	 * @throws FileNotFoundException
	 */
	public File[] downMultiFile (String []file,int []start,int []end)throws FileNotFoundException;
}
