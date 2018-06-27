package zkTest;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

public class ZKTest {

	String urlStr="hadoop102:2181,hadoop103:2181,hadoop104:2181";
	ZooKeeper zkCli;
//	@Test
	@Before
	public void initZK() throws IOException {
		zkCli = new ZooKeeper(urlStr, 2000, new Watcher() {
			
			@Override
			public void process(WatchedEvent event) {
				System.out.println(event.getType());
			}
		});
		
	}
	
	
	/**
	 * @Description：创建目录
	 * <p>创建人：Administrator ,  2018年6月27日  下午6:32:50</p>
	 * <p>修改人：Administrator ,  2018年6月27日  下午6:32:50</p>
	 *
	 * @throws IOException
	 * @throws KeeperException
	 * @throws InterruptedException
	 * void 
	 */
	@Test
	public void createNode() throws IOException, KeeperException, InterruptedException {
		String data="youhuan";
		String create = zkCli.create("/test", data.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println(create);
	}
	
	/**
	 * @throws InterruptedException 
	 * @throws KeeperException 
	 * @Description：获取子节点信息
	 * <p>创建人：Administrator ,  2018年6月27日  下午6:33:29</p>
	 * <p>修改人：Administrator ,  2018年6月27日  下午6:33:29</p>
	 *
	 * void 
	 */
	@Test
	public void getNode() throws KeeperException, InterruptedException {
		
		List<String> children = zkCli.getChildren("/", true);
		
		for (String string : children) {
			System.out.println(string);
		}
		
	}
	
	/**
	 * @throws InterruptedException 
	 * @throws KeeperException 
	 * @Description：获取子节点信息	
	 * <p>创建人：Administrator ,  2018年6月27日  下午6:37:27</p>
	 * <p>修改人：Administrator ,  2018年6月27日  下午6:37:27</p>
	 *
	 * void 
	 */
	@Test
	public void getNodeData() throws KeeperException, InterruptedException {
		
		byte[] data = zkCli.getData("/test", true, new Stat());
		System.out.println(new String(data));
		
	}
	
	
	/**
	 * @Description：获取节点是否存在
	 * <p>创建人：Administrator ,  2018年6月27日  下午6:49:18</p>
	 * <p>修改人：Administrator ,  2018年6月27日  下午6:49:18</p>
	 *
	 * @throws Exception
	 * @throws Exception
	 * void 
	 */
	@Test
	public void existNode() throws Exception, Exception{
		Stat exists = zkCli.exists("/test", true);
		System.out.println(exists);
	}
	
}
