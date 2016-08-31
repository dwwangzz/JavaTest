package ansj;

import org.ansj.app.summary.SummaryComputer;
import org.ansj.app.summary.TagContent;
import org.ansj.app.summary.pojo.Summary;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.List;

/**
 * java 分词
 */
public class Test {

	public static void main(String[] args) throws Exception {
		// boolean status = (int)(Math.random()*100)<=10?true:false;
		// System.out.println(Math.random()*100);
		// 判断时间点是否是在2015-06-08之前
		/*
		 * Calendar cld = Calendar.getInstance(); cld.set(2015,5,8,00,00,00);
		 * System.out.println(new
		 * SimpleDateFormat("yyyy-MM-dd").format(cld.getTime()));
		 * System.out.println(System.currentTimeMillis()<cld.getTimeInMillis());
		 */
		
		/*List<String> list = new ArrayList<String>();
		Map<String, String> mm = new HashMap<String,String>();
		mm.put("mm","mm");
		System.out.println(mm.toString());
		list.add("aaaaaaa");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status","success");
		map.put("map",new HashMap<String,String>().put("xiaomap","xiaomap"));
		map.put("mm",mm);
		map.put("ddd",new ArrayList<String>().add("ffffffff"));
		map.put("list",list.toString());
		System.out.println(map.toString());*/
		
		
        //String words = "中国是世界四大文明古国之一，有着悠久的历史，距今约5000年前，以中原地区为中心开始出现聚落组织进而成国家和朝代，后历经多次演变和朝代更迭，持续时间较长的朝代有夏、商、周、汉、晋、唐、宋、元、明、清等。中原王朝历史上不断与北方游牧民族交往、征战，众多民族融合成为中华民族。20世纪初辛亥革命后，中国的君主政体退出历史舞台，取而代之的是共和政体。1949年中华人民共和国成立后，在中国大陆建立了人民代表大会制度的政体。中国有着多彩的民俗文化，传统艺术形式有诗词、戏曲、书法和国画等，春节、元宵、清明、端午、中秋、重阳等是中国重要的传统节日。";  
        //System.out.println(ToAnalysis.parse(words)); 
        
		List<Term> parse = (List<Term>) BaseAnalysis.parse("让战士们过一个欢乐祥和的新春佳节。");
		System.out.println(parse);
		
		 String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
		 System.out.println(ToAnalysis.parse(str));
		 
		 
	}
	
	@org.junit.Test
	public void test1(){
		String query = "巴西世界杯" ;
		String title = "巴西世界杯记者手记：“格子军团”的悲情之战" ;
		String content = "经过一夜喧闹，圣保罗的球迷依然沉醉在主队首场击败克罗地亚的喜悦中。　　13日清晨，记者所在老城区，路面上已满是啤酒瓶和食物包装纸屑，当然，骑着摩托车，将高音喇叭开到最大的年轻人也大有人在，他们手中挥舞着巴西国旗，尖叫着“内马尔万岁”的口号。　　巴西球迷就是这样，赢球可以消除一切不开心，哪怕这个月收入还没有保障，但只要有足球，有啤酒，就会“及时行乐”。　　但如果输球后结局又会如何？一家杂货店的老板洛佩兹笑了笑说，“最好呆在家，早早关门停业。”　　不少与记者同住在一家酒店的克罗地亚球迷，今天早早选择退房。他们中有人会转战玛瑙斯，继续跟随主队的世界杯征程，也有人会选择回国，因为比赛一票难求，以及巴西高额的物价让人难以承受。　　对于昨夜的那场揭幕战结局，记者原本不想揭起克罗地亚球迷的伤疤，但23岁的布拉维奇似乎知道记者的意图，他直言道，“与其说是依靠内马尔的神奇表现拯救了巴西队，不如说克罗地亚队是被日本裁判打败，就是那颗误判的点球，扰乱了将士们的心绪。”　　“我们本可以创造奇迹。”布拉维奇目光坚毅地说。　　其实，这场与巴西队的比赛，无论从全队实力还是历史战绩，东道主球队明显占据上风，取得开门红也在情理之中。但谁又敢小看克罗地亚的能力？　　1998年的法国世界杯，克罗地亚正是在没人看好的情况下，由苏克率队获得季军，甚至在八强战中以3:0完胜德国，就此震惊世界。　　尽管在上届没能入围南非世界杯，但新生力量的涌现，再度让克罗地亚人看到希望。队中身价最高的莫德里奇目前效力于皇马，而曼朱基齐在德甲巨头拜仁慕尼黑队中更是担任着头号射手的角色。中前场的攻击能力，不输给任何对手。　　然而，真正走进巴西，在圣保罗体育场，他们没能挡住东道主的火力，以1：3败下阵来。　　球场内，600与60000的球迷数字之比，或许就是克罗地亚负于巴西足球的真实写照。　　赛后，对于这场失利，因对对手犯规造成点球判罚的洛夫伦说，“我努力不让自己哭泣，但你用一生去等待的东西，却最终裁判偷走了。他们为什么不直接把冠军奖杯送给巴西？”　　即将加盟巴塞罗那的拉基蒂奇也非常愤怒：“我们应该获得一场平局，很抱歉，我们必须要在第一场比赛后就谈论裁判。”　　平心而论，历届世界杯裁判问题都是外界关注的焦点，而首场比赛就出现争议判罚，让日本裁判西村雄一瞬间坐上了火山口。　　直到目前，国际足联仍未对西村雄一的执法工作给予任何评价。但让中国球迷记忆深刻的是，2005年东亚杯的中韩之战，西村雄一曾将郜林误认成李玮峰，结果给了郜林一张莫名其妙的红牌。　　本场比赛后，据法新社报道，日本球迷亦对西村雄一的争议判罚感到羞愧。一位日本网民调侃道：“如果巴西最终能夺得本次世界杯冠军，那么全世界都会认为西村雄一是本届大赛的MVP(最有价值球员)。”　　不过，对于克罗地亚来说，输掉首场比赛并非是世界末日，已连夜从圣保罗飞往玛瑙斯的他们，在接下来还要迎战喀麦隆和墨西哥，只要发挥出色，从小组出线依然留存希望。　　只是，他们是否还会遇到另一名日本裁判呢？" ;		
		SummaryComputer summaryC = new SummaryComputer(300, title , content) ;
		
		Summary summary = summaryC.toSummary(query) ;
		
		TagContent tagContent = new TagContent("<begin>", "<end>") ;
		
		String summaryStr = tagContent.tagContent(summary) ;
		
		System.out.println(summaryStr);
	}
	public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

}
