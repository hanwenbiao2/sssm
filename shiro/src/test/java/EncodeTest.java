import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Assert;
import org.junit.Test;


/**
 * @Author: HWB
 * @DateTime: 2019/6/4 13:45
 * @Description: TODO
 */
public class EncodeTest {
    private static Log log = LogFactory.getLog(EncodeTest.class);
    @Test
    public void TestEncode(){
        String str = "hello";
        String base64Encode = Base64.encodeToString(str.getBytes());
        System.out.println(base64Encode);
        String str2 = Base64.decodeToString(base64Encode);

        String str3 = "hello";
        String base64Encoded1 = Hex.encodeToString(str.getBytes());
        String str4 = new String(Hex.decode(base64Encoded1.getBytes()));
        System.out.println(base64Encoded1);
        Assert.assertEquals(str3, str4);
        String str5 = "hello";
        String salt = "123";
        String md5 = new Md5Hash(str, salt).toString();
    }
}
