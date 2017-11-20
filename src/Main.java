import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author 何炜
 * 算法名称：数据挖掘：Apriori算法求特性支持度下的所有的频繁集
 * 算法原理：
 *
 * 0. 获取C1的时候，因为没有L(0)频繁集，所以单独处理一个函数
 * 1. 已经频繁集L(k-1)，{}自连接+剪枝}求出精简后的候选集C(k)
 * 2. 根据精简后的候选集C(k)根据求出频繁集L(k)
 *
 * 数据结构：
 * 1. 使用List<String> 存储整个数据库的数据，string代表每一行的数据
 * 2. 使用HashMap<String,Integer> 存储项集以及项集的重复次数，便于查找
 */




public class Main {

    private static double SUPPORT_PERCENT = 0.05;
    private static int SUPPORT_NUM = 0;

    public static void main(String[] args) {
        System.out.println("===================Apriori算法主程序界面====================");

        //0. 输入数据
        /*Scanner in=new Scanner(System.in);
        SUPPORT_PERCENT = in.nextDouble();*/

        //1. 导入数据
        List<String> data2DList = new ArrayList<>();
        data2DList = importData();

        //2. 进行算法处理
        System.err.println("计算机正在运算中……");
        apriori(data2DList);



    }



    /**
     * Apriori算法主程序，需要递归处理
     *
     * @param dataList
     * @return
     */
    public static void apriori(List<String> dataList){

        Map<String, Integer> stepFrequentSetMap;

        //将C1候选map集合加入到stepFrequentSetMap
        stepFrequentSetMap = findCandidateOneSets(dataList);


        while(true){



        }

    }

    /**
     * 导入数据
     *
     * @return 集合和集合，即二维集合
     */
    private static List<String> importData(){

        List<String> data2DList = new ArrayList<>();
        File file = new File("retail.dat");

        try {
            //文件存在且为文件类型执行接下来的操作
            if (file.isFile() && file.exists()){
                InputStreamReader reader = new InputStreamReader(new FileInputStream(file),
                        "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(reader);
                String lineTxt;
                while ((lineTxt = bufferedReader.readLine()) != null){//读取文件中的一行

                    data2DList.add(lineTxt);
                }

                reader.close();
            }else {
                System.err.println("找不到指定文件！");
            }
        }catch (Exception e){
            System.err.println("读取文件内容出错！");
            e.printStackTrace();
        }

        return data2DList;
    }


    /**
     * 寻找1项的候选集C1（起始化特殊的处理）
     *
     * @param data2DList
     * @return 返回map集合，这个集合是每一项以及对应的重复次数：key->value
     *
     * key：每一个候选项/频繁项
     * value：相应候选项/频繁项的重复次数
     */
    private static HashMap<String, Integer> findCandidateOneSets(List<String> data2DList)
    {
        HashMap<String, Integer> resultSetMap = new HashMap<>();

        for(String dataList :data2DList)
        {
            String[] dataString = dataList.split(" ");
            //查询map集合中是否有该元素，如果没有，加入该元素，否则给该元素对于的value(重复次数）+1
            for (String string :dataString){

                if (resultSetMap.get(string) == null){
                    resultSetMap.put(string,1);
                }else {
                    resultSetMap.put(string,resultSetMap.get(string) + 1);
                }
            }
        }
        return resultSetMap;
    }



    /**
     * 从精简后的C(k)候选集中得到L(k)频繁集合
     *
     * {统计精简后的候选集C(k)的重复次数}  = {最后得到L(k)频繁集}
     *
     * 1. 对精简过的候选集进行计数，不满足支持度的进行排除
     *
     * @param minCandidateMapSet
     * @return
     */
    private static Map<List<String>, Integer> getFrequentSets(Map<List<String>, Integer> minCandidateMapSet){


        return null;
    }


    /**
     * 从L(k-1)频繁集合中得到精简的C(k)候选集
     *
     * 1. {连接 + 剪枝}  = {精简后的候选集C(k)}
     * 是对L(k-1)频繁集的每一个集合，进行[边连接成候选集，边剪枝]而不是先全部生成了{候选集}，然后再进行一次大循环，进行剪枝，这样会增加时间复杂度
     *
     * 先验原则：若某个集合存在一个非空子集不是频繁项集，则该集合不是频繁项集
     *
     * 1. 根据先验原则压缩候选集大小后得到精简的候选集集合
     *
     * @param frequentMapSet
     * @return
     */
    private static Map<List<String>, Integer> getMinCandidate(Map<List<String>, Integer> frequentMapSet){


        return null;
    }

}
