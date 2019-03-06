/*
 Navicat Premium Data Transfer

 Source Server         : LXX
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : SSM_Shopping_db

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 26/02/2019 18:53:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shopping_address
-- ----------------------------
DROP TABLE IF EXISTS `shopping_address`;
CREATE TABLE `shopping_address` (
  `id` char(32) NOT NULL COMMENT '收货地址ID',
  `userid` char(32) NOT NULL COMMENT '用户ID',
  `accept` varchar(20) DEFAULT NULL COMMENT '收货人',
  `zip` char(6) DEFAULT NULL COMMENT '邮编',
  `phoneNum` varchar(13) DEFAULT NULL COMMENT '收货人电话',
  `province` varchar(20) DEFAULT NULL COMMENT '省市',
  `city` varchar(20) DEFAULT NULL COMMENT '城市',
  `area` varchar(20) DEFAULT NULL COMMENT '区县',
  `address` varchar(30) DEFAULT NULL COMMENT '详细地址',
  `isdefault` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_address
-- ----------------------------
BEGIN;
INSERT INTO `shopping_address` VALUES ('02800a86bb7d4eabb7a91163a22baea4', '31c8ceddae0d43ef81b2596dfe0a997d', '凌俊豪', '245000', '18255908919', '安徽省', '黄山市', '屯溪区', '徽州大道鸿威东方丽景13栋1401室', '1');
INSERT INTO `shopping_address` VALUES ('0390a8c92d7b4eee92d6e59eb7442bb1', '31c8ceddae0d43ef81b2596dfe0a997d', '王梦雅', '245000', '18306763182', '安徽省', '池州市', '贵池区', '池州学院', '2');
COMMIT;

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `id` char(32) NOT NULL COMMENT '购物车id',
  `userid` char(32) NOT NULL COMMENT '用户id',
  `goodsid` char(32) NOT NULL COMMENT '商品id',
  `num` int(11) NOT NULL COMMENT '数量',
  `price` float NOT NULL COMMENT '价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
BEGIN;
INSERT INTO `shopping_cart` VALUES ('b24fa837812049d79a974a7f8a8c027f', '9b95764f22c544ff9440b4f3d26a6aac', '26d016d65acc47279e04cbcfb4e50b11', 1, 4799);
COMMIT;

-- ----------------------------
-- Table structure for shopping_category
-- ----------------------------
DROP TABLE IF EXISTS `shopping_category`;
CREATE TABLE `shopping_category` (
  `id` char(32) NOT NULL COMMENT '商品类别id',
  `name` varchar(255) NOT NULL COMMENT '商品名称',
  `goodsNum` int(11) NOT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_category
-- ----------------------------
BEGIN;
INSERT INTO `shopping_category` VALUES ('29a99b2e86c34c5c8abd6f7f0afe3d5a', '笔记本电脑', 8);
INSERT INTO `shopping_category` VALUES ('8a46f544f9e64b4a8e375769ed742180', '平板电脑', 4);
INSERT INTO `shopping_category` VALUES ('8dd27ab79c1b494999e5a3d2eec08fbf', '电脑配件', 13);
INSERT INTO `shopping_category` VALUES ('ac9f0e8e4a6a404b99963b21cd530b53', '数码相机', 8);
INSERT INTO `shopping_category` VALUES ('b156acb596774a6b8208ce7d76264cbe', '台式机', 9);
INSERT INTO `shopping_category` VALUES ('b6a2801b3edd4c18b78ffdf310620e91', '手机', 9);
INSERT INTO `shopping_category` VALUES ('f03607a30db043f6b330d42d00521bd1', '手机配件', 9);
COMMIT;

-- ----------------------------
-- Table structure for shopping_comment
-- ----------------------------
DROP TABLE IF EXISTS `shopping_comment`;
CREATE TABLE `shopping_comment` (
  `id` char(32) NOT NULL,
  `ownerid` char(32) NOT NULL,
  `targetid` char(32) NOT NULL,
  `statusnum` int(1) NOT NULL,
  `remark` varchar(256) DEFAULT NULL,
  `createtime` char(20) NOT NULL,
  `score` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_comment
-- ----------------------------
BEGIN;
INSERT INTO `shopping_comment` VALUES ('30ed9c94b2304894a1795b97783f3cb4', '31c8ceddae0d43ef81b2596dfe0a997d', 'd7bd9d5b986941ad9762677a66118244', 0, '很好的游戏体验', '2019-02-26  14:19:40', 5);
COMMIT;

-- ----------------------------
-- Table structure for shopping_goods
-- ----------------------------
DROP TABLE IF EXISTS `shopping_goods`;
CREATE TABLE `shopping_goods` (
  `id` char(32) NOT NULL COMMENT '商品ID',
  `goodsno` varchar(20) NOT NULL COMMENT '编号',
  `name` varchar(200) NOT NULL COMMENT '商品名称',
  `categoryid` char(32) NOT NULL COMMENT '分类编号',
  `price1` float NOT NULL COMMENT '原价',
  `price2` float NOT NULL COMMENT '现价',
  `stock` int(11) NOT NULL COMMENT '库存',
  `thumbnail` char(50) NOT NULL COMMENT '商品图片地址',
  `description` varchar(300) NOT NULL COMMENT '商品描述',
  `role` int(11) NOT NULL COMMENT '表示商品的热卖程度，值越大越靠前显示',
  `selltime` int(11) NOT NULL COMMENT '表示商品的新度，值越大，表示是新推出的商品',
  `sellnum` int(11) NOT NULL COMMENT '商品销量',
  `score` float NOT NULL COMMENT '用户评分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_goods
-- ----------------------------
BEGIN;
INSERT INTO `shopping_goods` VALUES ('0416baee9a524cb596c0609e54a064cc', 'XX20190226155303533', '手机直播支架桌面多功能补光美颜快手通用懒人三脚架女落地神器拍照视频配件支驾万能床头简约支撑架看片床上', 'f03607a30db043f6b330d42d00521bd1', 38, 18, 12783, 'goodsimage/678e56b4b8204922bc8b42df162cfc46.png', '产品参数：\r\n品牌: 标图颜色分类: 桌面标准款 桌面标准款+蓝牙遥控 桌面标准款+补光灯 桌面标准款+补光灯+蓝牙遥控 桌面加长款 桌面加长款+蓝牙遥控 桌面加长款+补光灯 桌面加长款+补光灯+蓝牙遥控 双手机固定款 双手机固定款+蓝牙遥控 双手机固定款+补光灯 双手机固定款+补光灯+蓝牙遥控 双手机伸缩款 双手机伸缩款+蓝牙遥控 双手机伸缩款+补光灯 双手机伸缩款+补光灯+蓝牙遥控 三脚落地款 三脚落地款+蓝牙遥控 三脚落地款+补光灯 三脚落地款+补光灯+蓝牙遥控 三脚落地款160+补光灯 三脚落地款160+补光灯+蓝牙遥控 三脚落地款220+补光灯 ', 8, 6, 53, 0);
INSERT INTO `shopping_goods` VALUES ('17127690b5124a939bcc72094f9dc540', 'XX201902261556405640', '手机扣指环扣支架vivo手指扣环OPPO创意环指多功能卡通超薄配件8plus苹果华为通用指环男女个性网红同款', 'f03607a30db043f6b330d42d00521bd1', 36, 18, 464, 'goodsimage/4d501df90496415e99f8c89c6303f6c7.png', '指环扣 桌面支架 小巧轻便 防刮耐磨\r\n品牌名称：Vpower\r\n产品参数：\r\n\r\n品牌: Vpower颜色分类: 黑色兔子 红色兔子 粉色兔子 黑色蘑菇 渐变色蘑菇 幻影紫蘑菇 收藏加购享优先发货（此项勿拍）生产企业: 深圳市乐天派科技有限公司货号: 蘑菇手机支架适用场景: 桌面', 4, 2, 24, 0);
INSERT INTO `shopping_goods` VALUES ('19f98a10e3114923945ea89dfba30a99', 'XX201902261425522552', 'dell戴尔G7游匣G3 G5笔记本7559电脑键盘15.6英寸保护17.3贴膜7566配件7588透明5577防尘罩全覆盖7567夜光', '8dd27ab79c1b494999e5a3d2eec08fbf', 39, 19, 231676, 'goodsimage/2892e1e356f34f1294fa15d95b5fdbbe.png', '轻薄全透光 舒适手感 准确贴合不粘手', 6, 4, 215, 0);
INSERT INTO `shopping_goods` VALUES ('1a061270fdd24c1ebf55748b95de6d0e', 'XX201902261422392239', '容惠微软surface pro6保护套新pro5平板电脑保护壳pro4皮套12.3英寸i5内胆电脑包二合一支架配件男女防摔创意', '8dd27ab79c1b494999e5a3d2eec08fbf', 368, 148, 3313, 'goodsimage/2054b63208204153bd2321f0b4309734.png', '保护套+电源包+钢化膜+笔+背膜 全套更省心', 8, 6, 64, 0);
INSERT INTO `shopping_goods` VALUES ('24275c9fbb184e53bdecbdc387d5a414', 'XX201902261549454945', '手机指环扣支架苹果X环扣手指扣环磁吸男款壳华为oppo女手环配件挂钩xs多功能超薄环车载指扣贴吸盘式', 'f03607a30db043f6b330d42d00521bd1', 56, 29, 12321, 'goodsimage/485b547593af488199428c8a70b1bc69.png', '15倍强吸附 超薄设计 硅胶护手', 5, 3, 263, 0);
INSERT INTO `shopping_goods` VALUES ('242fc21857f247db8396156ce55c6ee9', 'XX201902261517371737', '宁美国度i5 8500/GTX1050Ti台式吃鸡电脑主机全套DIY游戏组装整机', 'b156acb596774a6b8208ce7d76264cbe', 3999, 3199, 3171, 'goodsimage/1af13b932b9c4cb0b0eb9848303d940b.png', '热销64万台 行业爆款 旗舰机', 7, 6, 85, 0);
INSERT INTO `shopping_goods` VALUES ('26d016d65acc47279e04cbcfb4e50b11', 'XX201902261330193019', '【3期免息 套餐享小米小夜灯】小米笔记本电脑新品 15.6英寸8代i5独显 轻薄便携学生办公女生手提上网超薄本', '29a99b2e86c34c5c8abd6f7f0afe3d5a', 4999, 4799, 42, 'goodsimage/76147138d5c1413990ef0e09b05c7092.png', '八代I7处理器 MX110 2G独显', 9, 8, 40, 0);
INSERT INTO `shopping_goods` VALUES ('281d3943e6734df483d0f361297e58d9', 'XX20190226134507457', 'Apple/苹果 MacBook Pro MNQF2CH/A MPXV2 XX2笔记本电脑13寸15i7', '29a99b2e86c34c5c8abd6f7f0afe3d5a', 7864.44, 7078, 992, 'goodsimage/1314d61493024077a0b2bf9cc975d4b4.jpg', '16款13寸/256/无Bar/L42灰/UQ2银', 7, 7, 25, 0);
INSERT INTO `shopping_goods` VALUES ('3032445a247747a68f9c9932d55ee2ae', 'XX201902261431423142', '苹果Macbook屏幕清洁剂air13笔记本pro15电脑MAC键盘清洁套装配件鼠标灰尘指纹污渍吸清灰工具刷头擦布清理器', '8dd27ab79c1b494999e5a3d2eec08fbf', 79, 39, 8832, 'goodsimage/caf031ace57a4f88b72ee5fc5e04ffb1.png', '去污能手 强效清洁 日常养护 不含酒精', 7, 6, 74, 0);
INSERT INTO `shopping_goods` VALUES ('344a2abe9fd84a05a78d2dcd1a5d3170', 'XX201902261520152015', '超薄一体机电脑吃鸡台式主机全套i5i7游戏独显27英寸迷你家用办公', 'b156acb596774a6b8208ce7d76264cbe', 1699, 1399, 253, 'goodsimage/4e1377a1b80843358e9a99308067ecc6.png', '超薄一体机电脑吃鸡台式主机全套i5i7游戏独显27英寸迷你家用办公', 8, 5, 217, 0);
INSERT INTO `shopping_goods` VALUES ('3aa102c910f94b4e8f67f0643e5e9e0f', 'XX201902261435533553', '倍思type-c扩展坞macbookpro转接头usb-c转hdmi苹果电脑笔记本转换器雷电3配件type c 3.0配件', '8dd27ab79c1b494999e5a3d2eec08fbf', 488, 298, 1421, 'goodsimage/d8f222b773744e38bd173ac3ab4ade94.png', '智能五合一，办公更便携，更强大', 5, 5, 632, 0);
INSERT INTO `shopping_goods` VALUES ('3e2da17351014b3c815331f93b28e85d', 'XX201902261530553055', '到手价5358元起】Apple/苹果 iPhone XR 移动联通电信全网通版 苹果xr iphonexr 苹果xr手机 iphone xr', 'b6a2801b3edd4c18b78ffdf310620e91', 6488, 5888, 1087, 'goodsimage/10cac935a577473ca089588ab772beb9.png', '证书编号：2018011606102550证书状态：有效产品名称：TD-LTE 数字移动电话机3C规格型号：A2108(电源适配器可选：A1443 输出：5.0VDC 1A)产品名称：Apple/苹果 iPhone XRApple型号: iPhone XR机身颜色: 红色 珊瑚色 白色 黑色 黄色 蓝色运行内存RAM: 不详存储容量: 64GB 128GB 256GB网络模式: 不详', 10, 7, 585, 0);
INSERT INTO `shopping_goods` VALUES ('487e883c10014caab8c148a3a9fc278b', 'XX201902261541174117', '荣耀V20 华为HONOR/荣耀 荣耀V20胡歌同款拍照游戏手机全视屏智能旗舰手机官方旗舰店', 'b6a2801b3edd4c18b78ffdf310620e91', 3999, 3599, 494, 'goodsimage/a810146ffe0e41bb9b78304d2a5dd427.png', '现货速发 优选顺丰\r\n产品参数：\r\n\r\n证书编号：2018011606140650证书状态：有效产品名称：TD-LTE数字移动电话机3C规格型号：PCT-AL10 (开关电源适配器：HW-050450C00 输出：5VDC，2A 或 4.5VDC...产品名称：honor/荣耀 荣耀V20型号: 荣耀V20机身颜色: 魅海蓝 魅丽红 幻夜黑 MOSCHINO版幻影蓝 MOSCHINO版幻影红运行内存RAM: 6GB,8GB存储容量: 6+128GB 8+128GB 8+256GB网络模式: 双卡双待', 7, 6, 153, 0);
INSERT INTO `shopping_goods` VALUES ('4b411cffd83743f3babd036912e7d1b9', 'XX201902261529552955', 'haier/海尔乐享X1窄边框一体机电脑台式主机全套商务办公整机迷你酷睿i3i5i7四核独显网吧游戏型', 'b156acb596774a6b8208ce7d76264cbe', 3080, 2680, 2988, 'goodsimage/74ce6826089246bc8fc8e6f15278f05e.png', '产品参数：\r\n\r\n证书编号：2018010901118531证书状态：有效产品名称：一体机电脑3C规格型号：海尔**********，Haier**********，Aphro**********，乐趣***...产品名称：Haier/海尔 乐享X1-J316...内存容量: 8GB硬盘容量: 120GB台机CPU型号: 其他/other内存类型: DDR3显示器类型: LED操作系统: windows 10型号: j3160显卡型号: 核芯显卡\r\n', 8, 6, 121, 0);
INSERT INTO `shopping_goods` VALUES ('4bc04a93bb0446d0ad04ef7e977be361', 'XX201902261550375037', '手机散热器降温退热神器万能通用冷却风扇贴苹果刺激战场吃鸡物理辅助王者荣耀iphone x配件oppo小米游戏手柄', 'f03607a30db043f6b330d42d00521bd1', 99, 49, 442, 'goodsimage/54157e0be5c64599833e3c5422e331a9.png', '品牌: Joyroom/机乐堂颜色分类: 此项勿拍【收藏+购物车】尊享优先发货，365天免费换新 【骑士黑】LED炫光双风扇★快速降温★可边散热边充电 【象牙白】LED炫光双风扇★快速降温★可边散热边充电 收藏 加购生产企业: 东莞市机乐堂科技有限公司货号: 手机散热器', 7, 5, 131, 0);
INSERT INTO `shopping_goods` VALUES ('514cfe65d62442b1869c00a8a07e4e43', 'XX201902261441394139', 'Canon/佳能77D (18-135mm) 单反套机相机高清家用数码旅游相机', 'ac9f0e8e4a6a404b99963b21cd530b53', 6288, 6088, 15, 'goodsimage/4c2fcee954d746ae9de28c0325acdac3.png', 'DIGIC 7图像处理 全十字型双套对焦系统', 6, 6, 242, 0);
INSERT INTO `shopping_goods` VALUES ('5972dc61607242c9a60cdd426cea5d37', 'XX201902261352265226', 'Asus/华硕飞行堡垒6 i7/GTX1050ti 15.6英寸游戏手提笔记本电脑独显吃鸡游戏本学生FX86FE8750窄边框2018款', '29a99b2e86c34c5c8abd6f7f0afe3d5a', 7999, 6799, 86, 'goodsimage/1eb2e34bd953482890f9fdcb9947c8f2.jpg', '八代I7 1050Ti 6.5mm窄边框 256GSSDPCI-E', 7, 8, 132, 0);
INSERT INTO `shopping_goods` VALUES ('5aacb707419040438be5c5f1522f1d55', 'XX201902261439283928', '苹果笔记本保护壳macbook air电脑pro15透明磨砂13寸套12配件mac book贴膜软壳13.3贴纸11.6软11超薄15.6全套', '8dd27ab79c1b494999e5a3d2eec08fbf', 128, 48, 699, 'goodsimage/99c716cadaa044ecbdbd4fadbf6f7cde.png', '水晶透明显本色 磨砂舒适手感 任亲选择', 7, 6, 141, 0);
INSERT INTO `shopping_goods` VALUES ('5b1c5b44b19e4593b7a90dd641335b31', 'XX201902261554235423', '韩国apple watch series 4桌面充电小支架s4苹果智能运动手表44mm迷你硅胶保护s3充电器底座 创意潮配件', 'f03607a30db043f6b330d42d00521bd1', 298, 99, 213, 'goodsimage/a83c77596cc34848aeffb68db9b61105.png', '品牌名称：elago\r\n产品参数：\r\n品牌: elago颜色分类: 红色 白色 黑色 灰色 藏蓝色生产企业: ELAGO CO.,LTD.货号: W2适用场景: 床头', 6, 6, 231, 0);
INSERT INTO `shopping_goods` VALUES ('65b8803f262e4580ba33ff898a381b34', 'XX201902261424472447', '海备思苹果电脑转换器type-c转接头扩展坞macbookpro转hdmi拓展usb接口mac Air雷电3网线笔记本配件投影仪', '8dd27ab79c1b494999e5a3d2eec08fbf', 469, 229, 3171, 'goodsimage/8bc88962c0c140289da6d0ffb93edd3e.png', '多口合一，直插式设计，与您的电脑更配。', 6, 5, 12, 0);
INSERT INTO `shopping_goods` VALUES ('66498bc0994d478b9dd6a37bf3c9baa5', 'XX20190226150859859', '全新Canon/佳能EOS 60D 70D 80D单反高清 中端数码旅游男女照相机', 'ac9f0e8e4a6a404b99963b21cd530b53', 2600, 2100, 312, 'goodsimage/af25734bf5c9444ab3eb5cf8fed5a323.png', '全新Canon/佳能EOS 60D 70D 80D单反高清 中端数码旅游男女照相机', 4, 5, 211, 0);
INSERT INTO `shopping_goods` VALUES ('67f40cd8423b492b9dee685d18c2834c', 'XX201902261450535053', 'Canon/佳能PowerShot G7 X Mark II数码相机g7x mark2卡片机 G7X2', 'ac9f0e8e4a6a404b99963b21cd530b53', 4282, 3828, 312, 'goodsimage/8db02901860d4d8293ec40484c01fe92.png', 'Canon/佳能PowerShot G7 X Mark II数码相机g7x mark2卡片机 G7X2', 4, 6, 25, 0);
INSERT INTO `shopping_goods` VALUES ('68c7c9104a1c466aa21afa41d358abd3', 'XX20190226150645645', 'GoPro HERO7/6 BLACK出租赁 滑雪潜水运动相机4K黑狗数码摄像机', 'ac9f0e8e4a6a404b99963b21cd530b53', 3199, 2799, 297, 'goodsimage/b14554b544284144858eeef48860f527.png', 'GoPro HERO7/6 BLACK出租赁 滑雪潜水运动相机4K黑狗数码摄像机', 6, 5, 43, 0);
INSERT INTO `shopping_goods` VALUES ('6bf24957bb27420faa09dd72bd5c2342', 'XX201902261449104910', 'Canon/佳能EOS80D 18-135USM套机 中端高清单反 200D数码相机800D', 'ac9f0e8e4a6a404b99963b21cd530b53', 2400, 3500, 253, 'goodsimage/b8bd239cd92f4695ae09d8df853fce4d.png', '港货80D单机 不带镜头 港货80D 18-55STM 防抖镜头 港货80D 18-135STM 中长焦镜头 港货80D 18-135USM 中长焦镜头 港版80D 18-200IS 长焦镜头 港货80D+腾龙18-200一镜走天下', 5, 4, 26, 0);
INSERT INTO `shopping_goods` VALUES ('6d860207974144529f358b99d7ec3d5c', 'XX201902261445144514', 'Canon佳能EOS200D 800D入门级 白色单反女高清旅游数码照相机80D', 'ac9f0e8e4a6a404b99963b21cd530b53', 6599, 5799, 42, 'goodsimage/9b29d40401f447b8a109026ce5bc8a10.png', 'Canon佳能EOS200D ', 6, 5, 132, 0);
INSERT INTO `shopping_goods` VALUES ('6f6347005ef54ec8bd577822e336953e', 'XX20190226154503453', 'Meitu/美图 T9美图T9手机新款双卡双待美颜拍照手机 美图手机正品', 'b6a2801b3edd4c18b78ffdf310620e91', 2799, 2499, 312, 'goodsimage/650b5bdd5358443eab576ca75adb8cea.png', '全身美型、8种美颜模式、经典人像 电影人像\r\n证书编号：2018011606072100证书状态：有效产品名称：TD-LTE数字移动电话机3C规格型号：MP1718（电源适配器：MA-1803、MA-1801 输出：5.0V/9.0VDC 2A）产品名称：Meitu/美图 T9美图型号: T9机身颜色: 浆果红 湖光蓝 仙踪绿 星云粉运行内存RAM: 4GB 6GB存储容量: 6+128GB 4+64GB网络模式: 双卡多模CPU型号: 骁龙660', 6, 5, 206, 0);
INSERT INTO `shopping_goods` VALUES ('74a2464a4f02449d900cab6f525d9b3f', 'XX201902261432333233', '华为笔记本电脑matebook x高清钢化膜13.9英寸d防蓝光pro荣耀magicbook14锐龙版保护屏幕贴膜15.6配件13寸膜', '8dd27ab79c1b494999e5a3d2eec08fbf', 48, 108, 1421, 'goodsimage/8148a43feeff43419858189879b48fa4.png', '华为笔记本专用，高清防蓝光钢化防碎屏幕膜', 7, 6, 182, 0);
INSERT INTO `shopping_goods` VALUES ('7bbdc2920c5c4e90a930d0e18de8d64f', 'XX201902261540244024', 'OPPO R17全面屏拍照手机AI智能屏幕指纹美颜4G全网通学生旗舰正品oppor17新年版', 'b6a2801b3edd4c18b78ffdf310620e91', 3299, 2988, 5322, 'goodsimage/14bc2cfbcc5e4604a02e5d1c7701d537.png', '6期免息+蓝牙音箱 证书编号：2018011606100584证书状态：有效产品名称：TD-LTE数字移动电话机3C规格型号：PBEM00 （电源适配器：VC54JBCH、VC54GBCH、VC54HBCH；输出：5.0VDC...产品名称：OPPO R17OPPO型号: R17机身颜色: 流光蓝 霓光紫 雾光渐变色 雾光金运行内存RAM: 8GB存储容量: 8+128GB 6+128GB网络模式: 双卡多模', 6, 6, 168, 0);
INSERT INTO `shopping_goods` VALUES ('8404af106b14482eace665ea3e03ee69', 'XX201902261522292229', 'i7级e5办公八核高端电脑吃鸡游戏型家用高配组装台式主机整机全套', 'b156acb596774a6b8208ce7d76264cbe', 2366, 1856, 523, 'goodsimage/389d61af4e484c4eb09ae5862a064054.png', 'i7级e5办公八核高端电脑吃鸡游戏型家用高配组装台式主机整机全套', 7, 5, 152, 0);
INSERT INTO `shopping_goods` VALUES ('876248cdc25c41bfa6367951098dabe1', 'XX20190226140241241', '[12期分期][两年保修]Apple/苹果 iPad 2018款 9.7英寸wifi新款平板电脑32G/128G 正品国行新品官方授权旗舰', '8a46f544f9e64b4a8e375769ed742180', 2988, 2288, 1421, 'goodsimage/77cca60dbd004a09bea37211e0821070.png', '12期分期 官方授权 全国联保 假一赔十', 8, 6, 157, 0);
INSERT INTO `shopping_goods` VALUES ('88518f79f22a43d2a4a859911675a370', 'XX20190226140731731', 'Huawei/华为平板电脑M5青春版10.1英寸大屏2018新款AI智能语音安卓10寸4G平板手机二合一WiFi全网通话正品pad', '8a46f544f9e64b4a8e375769ed742180', 1919, 1499, 241, 'goodsimage/70bf6a9cf0dc470d8db1b0f44a67aa01.png', '新品首发 3期免息 AI智能语音 强劲续航', 4, 4, 143, 0);
INSERT INTO `shopping_goods` VALUES ('8c797a7475124ca8af2b818cfed323f8', 'XX201902261514231423', '大象摄影 Canon/佳能EOS M50 15-45高清旅游入门级数码微单反相机', 'ac9f0e8e4a6a404b99963b21cd530b53', 1375, 1100, 2102, 'goodsimage/dba763c5d7fc4755a0db30dbd557ab99.png', '黑色M50单机身 白色M50 +15-45mm套机 黑色M50 +15-45mm套机 白色M50 +15-45+25/F1.8双镜 黑色M50 +15-45+25/F1.8双镜', 5, 3, 109, 0);
INSERT INTO `shopping_goods` VALUES ('9661c54e036c4f0db4c6a22d2300e73d', 'XX201902261420212021', '2018新款macbook air苹果电脑pro13寸13.3笔记本mac键盘膜12保护15贴膜15.4英寸透明防尘贴薄配件', '8dd27ab79c1b494999e5a3d2eec08fbf', 48, 38, 1299, 'goodsimage/7e1e565d435946d581e7c53ae47a3fd3.png', '坚韧耐磨 轻薄高透 全透光', 9, 9, 92, 0);
INSERT INTO `shopping_goods` VALUES ('a2393f9164024bbe8ded74096d7857e9', 'XX201902261426492649', '通用转椅轮子万向轮老板办公椅子滚轮轱辘脚轮电脑椅配件滑轮静音', '8dd27ab79c1b494999e5a3d2eec08fbf', 19, 9.9, 21312, 'goodsimage/435bc07dbe604769a74e32def6b800d4.png', '5只装 单轴轮承重性强 静音无痕耐用', 4, 4, 57, 0);
INSERT INTO `shopping_goods` VALUES ('a7cd2716533e4d46909ee140320dab22', 'XX20190226153406346', 'Apple/苹果 iPhone XR 苹果iphonexr xs max双卡4G手机8', 'b6a2801b3edd4c18b78ffdf310620e91', 8659, 7988, 6421, 'goodsimage/23137475a3c246cda6d5cd3ec98fae8d.png', '品牌	Apple/苹果\r\nApple型号	iPhone XR\r\n款式	直板\r\n操作系统	iOS\r\n键盘类型	不详\r\n手机类型	4G手机\r\n屏幕屏幕\r\n触摸屏类型	以官网信息为准\r\n分辨率	1792 x 828\r\n网络网络\r\n网络类型	无需合约版\r\n网络模式	双卡双待\r\nCPU信息CPU信息\r\nCPU品牌	A12\r\n核心数	以官网信息为准\r\n存储存储\r\n运行内存RAM	以官网信息为准\r\n存储容量	64GB 128GB 256GB\r\n', 8, 7, 78, 0);
INSERT INTO `shopping_goods` VALUES ('a9188562c58844e29e6aa948c82a0ade', 'XX201902261547184718', 'Huawei/华为 nova 3手机官方旗舰店官网易烊千玺星耀版双4G全网通nova4青春版', 'b6a2801b3edd4c18b78ffdf310620e91', 2600, 2489, 7577, 'goodsimage/90a861f7a8f540efa5eaf07b75ef52d4.png', '咨询客服享优惠 顺丰速发\r\n证书编号：2018011606077896证书状态：有效产品名称：TD-LTE数字移动电话机3C规格型号：PAR-AL00（开关电源适配器：HW-059200CHQ 输出：5VDC 2A或9VDC ...产品名称：Huawei/华为 nova 3华为型号: nova 3机身颜色: 蓝楹紫 浅艾蓝 相思红 星耀版·樱草金 亮黑色运行内存RAM: 6GB存储容量: 6+64GB 6+128GB网络模式: 双卡双待单通', 7, 5, 23, 0);
INSERT INTO `shopping_goods` VALUES ('adbb7c0debe046fc8b37c38656686b80', 'XX201902261527372737', '英特尔i7台式电脑主机。英雄联盟水冷全套主播高配组装机1060地下城网吧1070吃鸡直播专用网咖游戏型apex英雄', 'b156acb596774a6b8208ce7d76264cbe', 5999, 5199, 5308, 'goodsimage/b68577414f414c78b04de10190b7e796.png', '品牌: Golden Field/金河田内存容量: 8GB 16GB硬盘容量: 240GB电源功率: 400W内存类型: DDR3显存容量: 8GB显存位宽: 256bit显存类型: GDDR5主板结构: ATX光驱类型: 无光驱独立显卡型号: 其他/otherCPU核心数: 四核心机箱结构: ATXCPU主频:2.4GHz(含)-2.8GHz(不含)配置类型: 豪华发烧型套餐类型: 套餐一 套餐二 套餐三 套餐四 套餐五 套餐六电源80 PLUS认证: 不支持显卡系列: GTX 1050显卡类型: 独立显卡内存频率: 1600MHz', 7, 5, 53, 0);
INSERT INTO `shopping_goods` VALUES ('b30394e9c6c44636afa550fe4f751b71', 'XX201902261311371137', 'Lenovo/联想拯救者Y7000 英特尔酷睿i5 游戏本笔记本电脑 (GTX1050Ti/2T+128G SSD/i5-8300H/8G)', '29a99b2e86c34c5c8abd6f7f0afe3d5a', 6599, 6299, 59, 'goodsimage/11ef70aa8622475b971db8275f4b2563.jpg', '大屏高配玩家游戏本', 6, 7, 16, 0);
INSERT INTO `shopping_goods` VALUES ('b7a0fc70fdac4fefb7063b09e23fbc8e', 'XX20190226133308338', '【6期免息下单立减300】2018新款 Apple/苹果 MacBook Air 八代i5 128G固态指纹 金属轻薄便携笔记本电脑', '29a99b2e86c34c5c8abd6f7f0afe3d5a', 10888, 9499, 214, 'goodsimage/fc6d8b07265e415697a342d8de24d089.jpeg', '【6期免息 支持指纹解锁】', 6, 6, 63, 0);
INSERT INTO `shopping_goods` VALUES ('bc561e6d7d7e4f6cae5cf81ae92164f6', 'XX201902261521312131', 'i7吃鸡电脑主机组装台式电脑全套高配网吧游戏型办公整机', 'b156acb596774a6b8208ce7d76264cbe', 1899, 1699, 312, 'goodsimage/7246d87f7e2440b3824c6b3507e6661e.png', 'i7吃鸡电脑主机组装台式电脑全套高配网吧游戏型办公整机', 7, 6, 46, 0);
INSERT INTO `shopping_goods` VALUES ('bcb78dc4dfa84a949968165f9226aea1', 'XX201902261545484548', 'Samsung/三星 Galaxy A8s SM-G8870新品4G智能全网通手机黑瞳全视屏三摄 学生机 官方正品 6期免息', 'b6a2801b3edd4c18b78ffdf310620e91', 3098, 2799, 1139, 'goodsimage/ece062aade474f148601e13413cda4d5.png', '6期免息 套餐二选一\r\n产品参数：\r\n\r\n证书编号：2018011606138454证书状态：有效产品名称：TD-LTE数字移动电话机3C规格型号：SM-G8870（旅行充电器：EP-TA200 输出： 9.0VDC 1.67A 或 5.0VDC ...产品名称：Samsung/三星 Galaxy A8s...三星型号: Galaxy A8s SM-G8870机身颜色: 精灵蓝 极光黑 外星银运行内存RAM: 6GB 8GB存储容量: 6+128GB 8+128GB网络模式: TD-LTE/LTE FDD/TD-SCDMA/WCDMA等', 8, 7, 85, 0);
INSERT INTO `shopping_goods` VALUES ('be78c176d37e411ebee7a6be7480c08e', 'XX201902261525312531', '名龙堂i7 8700/GTX1060 高配水冷台式电脑主机吃鸡游戏组装机全套', 'b156acb596774a6b8208ce7d76264cbe', 5889, 4998, 665, 'goodsimage/da7a4e08473548b4bdf67f9b72da9fd1.png', '产品参数：\r\n\r\n产品名称：MLOONG/名龙堂 Intel Z37...品牌: MLOONG/名龙堂内存容量: 16GB硬盘容量: 配置一 配置二 配置三 配置四电源功率: 400W显存容量: 6GB主板结构: M-ATX光驱类型: 无光驱生产企业: 武汉名龙堂科技有限公司电源80 PLUS认证: 不支持显卡系列: GTX 1060散热方式: 水冷硬盘类型: 固态硬盘(SSD)CPU系列: Intel/英特尔酷睿i7主板芯片组类型: Intel Z370保修期: 36个月CPU型号: i7-8700显卡芯片品牌: NVIDIA/英伟达', 9, 5, 26, 0);
INSERT INTO `shopping_goods` VALUES ('c131148c1be44e048e2a9ab2b307cf90', 'XX201902261421572157', '苹果笔记本屏幕钢化膜macbookair保护膜pro13寸13.3电脑mac贴膜15防辐射反光护眼小米屏保膜高清12apple配件', '8dd27ab79c1b494999e5a3d2eec08fbf', 98, 49, 655, 'goodsimage/12055bc00c274601abe109a406b48b90.png', '防刮花防爆钢化膜 高清高透 送触控板膜', 6, 7, 36, 0);
INSERT INTO `shopping_goods` VALUES ('ca16345b4f2341fb8d5b6e736837fb69', 'XX201902261350225022', 'Dell/戴尔灵越5370超薄轻薄便携商务办公学生超极笔记本手提电脑13.3英寸女生粉色2018款笔记本游戏本正品i5', '29a99b2e86c34c5c8abd6f7f0afe3d5a', 4399, 3899, 42, 'goodsimage/7c120b1374d94859821f33a7bef39b5b.jpg', '开新季火爆促销 联系客服领优惠', 6, 5, 42, 0);
INSERT INTO `shopping_goods` VALUES ('cb43e9805ed84007ae12a3ea6bf82f58', 'XX201902261427572757', '苹果电脑保护壳macbookpro笔记本air13寸13.3超薄15保护套mac贴膜15.4外壳配件12贴纸全套磨砂软壳book防摔', '8dd27ab79c1b494999e5a3d2eec08fbf', 116, 58, 8980, 'goodsimage/0464e2a93ca14e9d9c90a8c4e7cc78c7.png', '真机开模 轻薄散热 防刮耐磨 送同色键盘膜', 5, 4, 35, 0);
INSERT INTO `shopping_goods` VALUES ('d1c4394e449a4458af2c532cf4560adf', 'XX20190226140352352', 'Xiaomi/小米 小米平板4 大屏安卓超薄智能电脑4G高清', '8a46f544f9e64b4a8e375769ed742180', 1499, 1099, 1139, 'goodsimage/212e39bc6eac4a41ae2f947161fa9fa0.jpg', '轻薄机身 骁龙660', 5, 5, 55, 0);
INSERT INTO `shopping_goods` VALUES ('d38d2ec069a44aa7b04afc6b2d055f05', 'XX201902261551185118', '手机指环扣支架8苹果x手指plus环扣神器磁吸壳挂钩男女款创意个性vivo华为oppo金属超薄多功能通用车载架配件', 'f03607a30db043f6b330d42d00521bd1', 88, 58, 1421, 'goodsimage/b372d9ca22a54a3590eee730dedc76a8.png', '品牌名称：ESR 产品参数：品牌: ESR颜色分类: 开年钜惠：全店满300送蓝牙耳机 买2片立减15★送2片3M强力胶 【曜石黑】电镀合金材质★360°旋转★超薄?1片装 【开运红】电镀合金材质★360°旋转★超薄?1片装 【流星银】电镀合金材质★360°旋转★超薄?1片装 预售：【香槟金】电镀合金材质★360°旋转★超薄?1片装 【双黑色】电镀合金材质★360°旋转★超薄?2片装 【双银色】电镀合金材质★360°旋转★超薄?2片装 【双红色】电镀合金材质★360°旋转★超薄?2片装 【黑+银】电镀合金材质★360°旋转★超薄?2片装 ', 6, 7, 76, 0);
INSERT INTO `shopping_goods` VALUES ('d576a8e8c7b84faea138977239280344', 'XX201902261221582158', 'Lenovo/联想 拯救者 Y7000P i7游戏本学生手提笔记本英特尔酷睿八代六核15.6英寸电竞游戏笔记本电脑GTX1060', '29a99b2e86c34c5c8abd6f7f0afe3d5a', 7899, 7799, 199, 'goodsimage/31ab70f615244ecd8c688bdd4445145e.jpg', '六核 i7 GTX1060独显6G 高色域 144Hz电竞屏', 8, 7, 47, 0);
INSERT INTO `shopping_goods` VALUES ('d6070b08863d424e8cba39ce7948cc59', 'XX201902261537333733', '荣耀10华为HONOR/荣耀 10GT游戏全面屏全网通双卡双待正品手机官方旗舰店', 'b6a2801b3edd4c18b78ffdf310620e91', 2599, 2199, 814, 'goodsimage/3bde91bd7d94455fb9e37d134aed87a5.png', '产品参数：\r\n\r\n证书编号：2018011606057572证书状态：有效产品名称：TD-LTE数字移动电话机3C规格型号：COL-AL10（开关电源适配器：HW-050450C00，输出：5VDC 2A ，5VDC 4.5...产品名称：honor/荣耀 荣耀10型号: 荣耀10机身颜色: 铃兰白 海鸥灰 幻夜黑 幻影蓝 幻影紫运行内存RAM: 6GB 8GB存储容量: 6+128GB 6+64GB 8+128GB网络模式: 双卡双待', 8, 5, 73, 0);
INSERT INTO `shopping_goods` VALUES ('d7bd9d5b986941ad9762677a66118244', 'XX201902261148274827', 'Lenovo/联想 IdeaPad S130-14英寸2019笔记本电脑四核超轻薄便携商务办公学生家用游戏酷睿i3同性能', '29a99b2e86c34c5c8abd6f7f0afe3d5a', 3000, 2895, 252, 'goodsimage/19ddc9588fd1480f9839c65fbc89c725.jpg', '7代处理器 超轻薄 14英寸 长时续航', 8, 8, 92, 0);
INSERT INTO `shopping_goods` VALUES ('e8a1e6c21e6f4b8ab4317f623b937767', 'XX201902261524342434', '22-27英寸曲面一体机电脑游戏独显酷睿i3i5i7办公家用台式整机主机全套', 'b156acb596774a6b8208ce7d76264cbe', 1749, 1499, 432, 'goodsimage/31b8e1004fa849378389b1111d5a85ed.png', '产品参数：\r\n\r\n证书编号：2018010901120320证书状态：有效产品名称：多媒体一体机电脑3C规格型号：XX19A、XX19B、XX19C、XX19D、XX20A、XX20B、XX20C、XX20D、XX...产品名称：新想 XX22D型号: XX22D内存容量: 4GB硬盘容量: 500GB内存类型: 1600MHz DDR3显卡类型: 独立显卡显示器类型: LED操作系统: Windows 7', 7, 4, 48, 0);
INSERT INTO `shopping_goods` VALUES ('eb591b57f5954daa8d7c87f4cff5a3e2', 'XX201902261429182918', '易可利电脑冷热切带机拉链魔术贴织带机松紧带全自动剪带机配件', '8dd27ab79c1b494999e5a3d2eec08fbf', 2000, 1800, 14653, 'goodsimage/cfd2e5d30aa945ebb84550c5b07af99a.png', '\r\n第三代986单冷切机 第三代988T冷热切 螺纹带装置单热机 红外线定位商标机 第三代987单热切 刀片旋转斜切机 松紧带送料装置 140加宽冷热机 切斜角单热机 自动束冷热带机', 2, 2, 102, 0);
INSERT INTO `shopping_goods` VALUES ('ece0367afda94b36b4955e0601426503', 'XX201902261542354235', 'OPPO R15x 全网通屏幕指纹手机全面屏官方全新拍照美颜旗舰正品4Goppor15xr17r11k1', 'b6a2801b3edd4c18b78ffdf310620e91', 2399, 2299, 8022, 'goodsimage/9a640c71fa4b4db0a6b226cac17779fa.png', '6G+128G | 光感屏幕指纹 | 前置2500万\r\n证书编号：2018011606113631证书状态：有效产品名称：TD-LTE数字移动电话机3C规格型号：PBCM30（电源适配器：AK733YH、AK733KX、AK733JH、AK733CY、AK733...产品名称：OPPO R15x 全网通OPPO型号: R15x 全网通机身颜色: 星云渐变 冰萃银运行内存RAM: 6GB存储容量: 6+128GB网络模式: 双卡多模CPU型号: SDM660', 4, 3, 27, 0);
INSERT INTO `shopping_goods` VALUES ('ee2ab08e430f46398dce60f6ea1edaf0', 'XX201902261412521252', '绿联Type-C扩展坞拓展雷电3苹果电脑转换器Macbookpro配件hdmi适用mate20华为matebook笔记本USB转接头扩展器', '8dd27ab79c1b494999e5a3d2eec08fbf', 199, 99, 1569, 'goodsimage/2701be3cdc3b4ee9bea409cf323b6a5b.png', '外接大屏 87W PD快充 扩展USB接口', 2, 5, 15, 0);
INSERT INTO `shopping_goods` VALUES ('f1e81593e48646e78794eb86cefe7921', 'XX201902261548134813', '倍思红外线发射遥控头苹果红外遥控头安卓通用型vivo万能遥控器配件iPhone手机器oppo防尘塞', 'f03607a30db043f6b330d42d00521bd1', 59, 29, 1139, 'goodsimage/60ce17daeba648a8beb620cd14e05086.png', '一键遥控 一物两用 旋转控制 多色可选\r\n品牌名称：BASEUS/倍思\r\n产品参数：\r\n\r\n材质: 合金适用对象: 3.5MM耳机插孔品牌: BASEUS/倍思生产企业: 深圳市时商创展科技有限公司颜色分类: 赠送黑色保护套【遥控距离增', 6, 4, 3, 0);
INSERT INTO `shopping_goods` VALUES ('f8c86e65d82c49efac093bf0b2f4503f', 'XX20190226140952952', '【12期免息】微软 Surface Pro 6 i5 8GB 128GB 12.3英寸 笔记本电脑 平板电脑二合一 win10 学生 新品', '8a46f544f9e64b4a8e375769ed742180', 7188, 6988, 388, 'goodsimage/518e1feb580c441cb8f59336b349c494.png', '12期免息0首付 赠送延保一年', 6, 5, 7, 0);
INSERT INTO `shopping_goods` VALUES ('fbebc1077ec34d81bb63edfcf4cece37', 'XX201902261558515851', '苹果X通用i8P手机防尘塞Xs Max 金属iPhone7Plus电源塞充电口配件', 'f03607a30db043f6b330d42d00521bd1', 14, 9, 8532, 'goodsimage/212f08342de341f190a56930f684b354.png', '品牌名称：Aigo/爱国者\r\n产品参数：材质: 合金颜色分类: 苹果通用【指定颜色】x【4套】★配送防丢线套与收纳盒 苹果通用【指定颜色】x【3套】★配送防丢线套与收纳盒 苹果通用【玫瑰金】x【2套】★配送防丢线套与收纳盒 苹果通用【金色】x【2套】★配送防丢线套与收纳盒 苹果通用【银色】x【2套】★配送防丢线套与收纳盒 苹果通用【黑色】x【2套】★配送防丢线套与收纳盒 苹果通用【红色】x【2套】★配送防丢线套与收纳盒 苹果通用【玫瑰金】x【1套】★配送防丢线套与收纳盒 苹果通用【金色】x【1套】★配送防丢线套与收纳盒 苹果通用【银色】x【1套】', 5, 6, 21, 0);
INSERT INTO `shopping_goods` VALUES ('ff823135bcba4f4980a21606d48f9354', 'XX201902261528592859', '昂台一体机电脑四核i3i5i7办公家用游戏独显台式主机全套整机包邮', 'b156acb596774a6b8208ce7d76264cbe', 4756, 4399, 1421, 'goodsimage/d0624d1f8bb24a42b8f4ebaec37b7129.png', '简约轻薄 静音 内置摄像头 无线WiFi\r\n证书编号：2014010901740791证书状态：有效申请人名称：广州智益仁电子科技有限公司制造商名称：广州智益仁电子科技有限公司产品名称：一体机电脑3C产品型号：AP22xxPyy、 AP22xxRyy(xx表示A-Z、a-z、0-9或空格,yy表示0-9,代表...3C规格型号：AP22xxPyy、 AP22xxRyy(xx表示A-Z、a-z、0-9或空格,yy表示0-9,代表...产品名称：ONTAI/昂台 AP23A型号: AP23A内存容量: 4GB硬盘容量: 120GB台机CPU型号: 其他/other', 3, 1, 52, 0);
INSERT INTO `shopping_goods` VALUES ('ffcbfa65ff364636982d22d2ebe466e8', 'XX201902261555395539', '三机位支架配件 手机直播支架拍照三脚架', 'f03607a30db043f6b330d42d00521bd1', 103, 63, 523, 'goodsimage/6ff33399526a41d386fc9f57e67f1b09.png', '品牌名称：宾丽\r\n产品参数：\r\n\r\n品牌: 宾丽货号: LY2018B06颜色分类: 三机位+3个手机夹 三机位+2个手机夹+1个平板夹生产企业: 连云港灵跃贸易有限公司', 7, 4, 13, 0);
INSERT INTO `shopping_goods` VALUES ('ffd7da8e61264061bfa03ce3b6827ddc', 'XX201902261511271127', 'Canon/佳能M100 15-45套机 蚂蚁摄影 EOS 高清数码旅游女男 vlog 微单相机 入门级 女学生款 eos m100', 'ac9f0e8e4a6a404b99963b21cd530b53', 2799, 2399, 117, 'goodsimage/f1b972a3158f432ebe4d74a3e45dd5d5.png', '抢迷你三脚架，套餐三0元换购套四，立省190', 4, 3, 63, 0);
COMMIT;

-- ----------------------------
-- Table structure for shopping_order
-- ----------------------------
DROP TABLE IF EXISTS `shopping_order`;
CREATE TABLE `shopping_order` (
  `id` char(32) NOT NULL COMMENT '订单id',
  `userid` char(32) NOT NULL COMMENT '用户id',
  `ordertime` date NOT NULL COMMENT '生成订单时间',
  `paytype` char(30) NOT NULL COMMENT '支付方式',
  `paytime` date DEFAULT NULL COMMENT '支付时间',
  `sendtime` date DEFAULT NULL COMMENT '送货时间',
  `completiontime` date DEFAULT NULL COMMENT '订单完结时间',
  `addressid` char(32) DEFAULT NULL COMMENT '收货地址id',
  `totalmoney` float NOT NULL COMMENT '最终付款',
  `deliverytype` varchar(30) NOT NULL COMMENT '送货方式',
  `deliverytime` varchar(30) NOT NULL COMMENT '送货时间',
  `status` char(1) NOT NULL COMMENT '状态',
  `deliverynum` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_order
-- ----------------------------
BEGIN;
INSERT INTO `shopping_order` VALUES ('19ecea6be78c42db93671518550f803c', '31c8ceddae0d43ef81b2596dfe0a997d', '2019-02-26', '预存款支付', '2019-02-26', NULL, NULL, '0390a8c92d7b4eee92d6e59eb7442bb1', 2895, '快递', '任意', '1', NULL);
INSERT INTO `shopping_order` VALUES ('19fd4e7a526f48a8ad31c6c69da06e87', '31c8ceddae0d43ef81b2596dfe0a997d', '2019-02-26', '预存款支付', '2019-02-26', NULL, NULL, '0390a8c92d7b4eee92d6e59eb7442bb1', 5888, '快递', '任意', '1', NULL);
INSERT INTO `shopping_order` VALUES ('7dcc2fa9795143939965f267a91d4283', '31c8ceddae0d43ef81b2596dfe0a997d', '2019-02-26', '预存款支付', '2019-02-26', NULL, NULL, '02800a86bb7d4eabb7a91163a22baea4', 7799, '快递', '任意', '1', NULL);
COMMIT;

-- ----------------------------
-- Table structure for shopping_orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `shopping_orderdetail`;
CREATE TABLE `shopping_orderdetail` (
  `id` char(32) NOT NULL COMMENT '订单信息ID',
  `orderid` char(32) NOT NULL COMMENT '订单ID',
  `goodsid` char(32) NOT NULL COMMENT '商品ID',
  `nums` int(11) NOT NULL COMMENT '数量',
  `paystatus` int(11) DEFAULT NULL COMMENT '支付状态',
  `sendstatus` int(11) DEFAULT NULL COMMENT '运送状态',
  `orderstatus` int(11) DEFAULT NULL COMMENT '订单状态',
  `dealprice` double DEFAULT NULL COMMENT '交易价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_orderdetail
-- ----------------------------
BEGIN;
INSERT INTO `shopping_orderdetail` VALUES ('474560ab4184490ca40926c26f8669fb', '7dcc2fa9795143939965f267a91d4283', 'd576a8e8c7b84faea138977239280344', 1, 1, 0, 2, 0);
INSERT INTO `shopping_orderdetail` VALUES ('6413eb3e88954d1faf698a34c2546bf9', '19fd4e7a526f48a8ad31c6c69da06e87', '3e2da17351014b3c815331f93b28e85d', 1, 1, 0, 2, 0);
INSERT INTO `shopping_orderdetail` VALUES ('c446abf506c242488be0889a93f604e7', '19ecea6be78c42db93671518550f803c', 'd7bd9d5b986941ad9762677a66118244', 1, 1, 0, 2, 0);
COMMIT;

-- ----------------------------
-- Table structure for shopping_orderstatus
-- ----------------------------
DROP TABLE IF EXISTS `shopping_orderstatus`;
CREATE TABLE `shopping_orderstatus` (
  `id` char(32) NOT NULL COMMENT '状态id',
  `statusname` varchar(255) DEFAULT NULL COMMENT '状态名称',
  `statusnum` int(11) DEFAULT NULL COMMENT '各状态数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shopping_user
-- ----------------------------
DROP TABLE IF EXISTS `shopping_user`;
CREATE TABLE `shopping_user` (
  `ID` char(32) NOT NULL COMMENT '用户ID',
  `name` varchar(20) NOT NULL COMMENT '用户昵称',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `phonenum` char(11) NOT NULL COMMENT '电话号码',
  `money` float NOT NULL COMMENT '用户余额',
  `user_img` varchar(50) DEFAULT NULL COMMENT '用户头像地址',
  `regTime` varchar(20) NOT NULL COMMENT '注册时间',
  `role` char(1) DEFAULT NULL COMMENT '权限-u开头的为普通用户||a开头的为管理员',
  `status` int(11) DEFAULT NULL COMMENT '登录状态-1:在线、2:离线。其他：不可登录状态',
  `email` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_user
-- ----------------------------
BEGIN;
INSERT INTO `shopping_user` VALUES ('256a3cc731794b0ba6e4885e3f9cfb5f', '凌俊豪', 'maybetrue', '18255908919', 0, NULL, '2019-02-21  17:45:11', 'u', 0, 'ma@qq.com');
INSERT INTO `shopping_user` VALUES ('31c8ceddae0d43ef81b2596dfe0a997d', 'Lxx', 'maybetrue', '18255908919', 983418, NULL, '2019-02-21  17:48:18', 'a', 1, 'ma@qq.com');
INSERT INTO `shopping_user` VALUES ('5cb77575ccfb49bb95abf71940717901', 'admin', 'admin', '18255908919', 0, NULL, '2019-02-26  13:23:36', 'a', 0, '847587959@qq.com');
INSERT INTO `shopping_user` VALUES ('9b95764f22c544ff9440b4f3d26a6aac', '王梦雅', '123456', '18306763182', 0, NULL, '2019-02-24  16:37:10', 'a', 1, '11@qq.com');
INSERT INTO `shopping_user` VALUES ('c127160b9fdd42bd84926a0ad8cbeea7', '丽丽丽丽', '123456', '18255908919', 0, NULL, '2019-02-24  17:57:00', 'u', 0, '11@qq.com');
COMMIT;

-- ----------------------------
-- Table structure for visit
-- ----------------------------
DROP TABLE IF EXISTS `visit`;
CREATE TABLE `visit` (
  `id` char(32) NOT NULL COMMENT 'id',
  `ip` varchar(64) NOT NULL COMMENT 'ip',
  `username` varchar(32) NOT NULL COMMENT 'username',
  `logintime` varchar(20) NOT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visit
-- ----------------------------
BEGIN;
INSERT INTO `visit` VALUES ('01598fa268584e6297e097da274427ea', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  14:08:02');
INSERT INTO `visit` VALUES ('0816665dc33245aa9a8bf1f88b52f80a', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-21  17:48:23');
INSERT INTO `visit` VALUES ('08551e5cbb20485d84ed5611dd9cd668', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  13:35:53');
INSERT INTO `visit` VALUES ('0f67ddbe17c14edd99ad9fad3b678aba', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  16:36:04');
INSERT INTO `visit` VALUES ('0f89f7eef7594cd88b42dbb7e6c2c7e6', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  11:35:54');
INSERT INTO `visit` VALUES ('1bde83f4a4c742bc864cea187211562f', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  17:24:57');
INSERT INTO `visit` VALUES ('1df1909d1c0549949736ab31e077f8cb', '0:0:0:0:0:0:0:1', '???', '2019-02-24  17:27:58');
INSERT INTO `visit` VALUES ('1f43a59d83224a76b56c24958ac8653e', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  11:55:07');
INSERT INTO `visit` VALUES ('216840ccafc24feb8aa85cb71789c5f9', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  12:17:58');
INSERT INTO `visit` VALUES ('22c71ac68eb441f7832c69e3432310fa', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  15:33:13');
INSERT INTO `visit` VALUES ('24b516bcc6f843d5a9e414e90deafd58', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  16:02:42');
INSERT INTO `visit` VALUES ('262f1fb3b65d4f16905e643db7253ab3', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  11:43:48');
INSERT INTO `visit` VALUES ('2717e77544904018a367496eab1a644d', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-23  19:32:40');
INSERT INTO `visit` VALUES ('2ac195b02b77414ca68c488d151e4d3a', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  12:21:51');
INSERT INTO `visit` VALUES ('2c5b9ccff7b748b7acd710a1fefaccac', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  16:22:42');
INSERT INTO `visit` VALUES ('2f4ecae9685f4bb795612dd18b3c6201', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  13:40:52');
INSERT INTO `visit` VALUES ('2f703111196f4e8bbf2327b975ad22b1', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-23  21:27:34');
INSERT INTO `visit` VALUES ('3269afa2322541b9890a77e8b66ff417', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  15:36:21');
INSERT INTO `visit` VALUES ('338c3a9dd85e4b4ab2542e404c5c127b', '0:0:0:0:0:0:0:1', '?', '2019-02-24  17:40:20');
INSERT INTO `visit` VALUES ('35f3c8e680724044b9e53026c0b14d43', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  14:54:27');
INSERT INTO `visit` VALUES ('38ec435b7f944982a6a2d2ddc7e41d8d', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  13:29:17');
INSERT INTO `visit` VALUES ('3a82adf3044941ed85f14f9b9e76ecd0', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  12:34:12');
INSERT INTO `visit` VALUES ('3ae9e9c7cb7d4786a6c8492a759ceae0', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  14:04:00');
INSERT INTO `visit` VALUES ('3f440f992a0d4df9adc1c30a9e968f86', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  11:25:59');
INSERT INTO `visit` VALUES ('3f6dda51971a4d9cbf2824a64b28b532', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  11:31:23');
INSERT INTO `visit` VALUES ('3f73ac9b7e7b4c1e8b47d77249d60ee6', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  11:22:10');
INSERT INTO `visit` VALUES ('432d31ed43ae49e9b029d4d991774864', '0:0:0:0:0:0:0:1', '???', '2019-02-21  17:42:32');
INSERT INTO `visit` VALUES ('456e8d99a079427e8f8c5a95afe9a9aa', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  11:57:03');
INSERT INTO `visit` VALUES ('482630b46e714bcd9601f65db6e30cf9', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  16:21:15');
INSERT INTO `visit` VALUES ('4c29cc79853d4db19783ec020c44357f', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  15:42:47');
INSERT INTO `visit` VALUES ('4f2c5e3b13d24052a6fc8d384eea4a74', '0:0:0:0:0:0:0:1', '王梦雅', '2019-02-26  16:29:23');
INSERT INTO `visit` VALUES ('54e7460857ed4248994e7b0828853c3a', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  14:07:27');
INSERT INTO `visit` VALUES ('582791b0c23740afac7b85be035caa9c', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  12:03:02');
INSERT INTO `visit` VALUES ('5cbf287955cb46dda880b3e132e9984d', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  14:48:03');
INSERT INTO `visit` VALUES ('60d760a35f0d41c99d8c8a774cc6f0be', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  12:45:43');
INSERT INTO `visit` VALUES ('6235ac64b120478d9df7a20329917566', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  12:39:29');
INSERT INTO `visit` VALUES ('625922ffaf7f4500b4ba173811f9f526', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  13:57:50');
INSERT INTO `visit` VALUES ('64a457f1ff5a4da38d87dc7c983132ce', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-23  21:34:19');
INSERT INTO `visit` VALUES ('668ecb6f08a349509e7bb57a03f5e3ac', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-23  19:22:54');
INSERT INTO `visit` VALUES ('6a7491e5a18f426ea4d5489eda77ee2a', '0:0:0:0:0:0:0:1', '丽丽丽丽', '2019-02-24  17:57:12');
INSERT INTO `visit` VALUES ('6aa3846b0b464e70887757df5a1110e3', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  12:41:07');
INSERT INTO `visit` VALUES ('6afd136d7ce84d30aeb792853f28e00d', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  16:10:14');
INSERT INTO `visit` VALUES ('6c92c39aaaa24d4da7c0bb6fe26c9327', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  11:42:43');
INSERT INTO `visit` VALUES ('6dc221e664544869851b0e139984cab4', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  14:58:24');
INSERT INTO `visit` VALUES ('71092e4cd8064851a42310cab239ce92', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  16:17:28');
INSERT INTO `visit` VALUES ('71ea1c9a5410450dbf5c8380e2e9554a', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  13:39:50');
INSERT INTO `visit` VALUES ('73f9ed3379d64115bb5474fba6c9b279', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  10:38:24');
INSERT INTO `visit` VALUES ('7dae9af98cad4e8eb087e0efbb92cc21', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  14:05:23');
INSERT INTO `visit` VALUES ('7f06fb1049a845abb09a61c05470ee24', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  13:55:34');
INSERT INTO `visit` VALUES ('8662401efac24a23bc4c18a3d83c24f5', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  13:42:39');
INSERT INTO `visit` VALUES ('8c53d46ec7d24e0987ed9f76953255c6', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  13:32:26');
INSERT INTO `visit` VALUES ('8d404c9071ed40149b62102ec54c1eb0', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  15:46:02');
INSERT INTO `visit` VALUES ('8e06ad071dc8444580256d3eb1e0ca54', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  16:19:20');
INSERT INTO `visit` VALUES ('8f2481f81b9847208159cddc0b96b7ad', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  17:57:56');
INSERT INTO `visit` VALUES ('8f2d77483d3e4d64b0d0e129fb19836e', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  14:22:56');
INSERT INTO `visit` VALUES ('9490766ad6f149b8999e9d70aabe4d13', '0:0:0:0:0:0:0:1', '凌俊豪', '2019-02-24  17:57:45');
INSERT INTO `visit` VALUES ('97125e060bef45caa191076687e6f664', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  13:07:08');
INSERT INTO `visit` VALUES ('97624d580121497481757e3fc3eb4689', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  16:40:31');
INSERT INTO `visit` VALUES ('9c174d0003ec45bba748c545af79a77b', '0:0:0:0:0:0:0:1', '???', '2019-02-24  16:37:18');
INSERT INTO `visit` VALUES ('9d4008dac69a4ba38fd4234ca84e3321', '0:0:0:0:0:0:0:1', '???', '2019-02-21  17:39:46');
INSERT INTO `visit` VALUES ('9d7930513f2e48f984cd5617f03c7f7b', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  14:20:44');
INSERT INTO `visit` VALUES ('a01a07be9d184e5dbf30b7b14f8646a1', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  13:30:12');
INSERT INTO `visit` VALUES ('a1ae451a50074a33a062d913317dc6b4', '0:0:0:0:0:0:0:1', '??', '2019-02-24  17:43:26');
INSERT INTO `visit` VALUES ('a4bc75a51c274bf6b8cd9201cd0a2310', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-23  21:12:54');
INSERT INTO `visit` VALUES ('a528c1971ed84241a86b82f758f33ed6', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  11:33:16');
INSERT INTO `visit` VALUES ('a6cfa81a537b4b719babe33031526056', '0:0:0:0:0:0:0:1', '?', '2019-02-24  17:36:57');
INSERT INTO `visit` VALUES ('a6e49a1ba0844d558208b2cbaa9afda1', '0:0:0:0:0:0:0:1', '???', '2019-02-21  17:48:40');
INSERT INTO `visit` VALUES ('a72b32f89c044e668a45d87cab5ede1b', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  11:21:01');
INSERT INTO `visit` VALUES ('a79e3e5a622e45afa35f0b94f61fed8f', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  16:04:45');
INSERT INTO `visit` VALUES ('ae96406f3fab41ddb960169b5a14dcb2', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  14:06:21');
INSERT INTO `visit` VALUES ('ae9d33d8336149029b8c90ed340441bf', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  16:35:09');
INSERT INTO `visit` VALUES ('afa9be91558f4d169119c4c525ec407e', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  11:48:20');
INSERT INTO `visit` VALUES ('b32528a4e21a43c3994586a7ca86588f', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  15:32:10');
INSERT INTO `visit` VALUES ('b932f69e25d5454fbcdf4d62cbcc1543', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  14:00:40');
INSERT INTO `visit` VALUES ('bda2bea71845425b94ef8ebc16fc4b1d', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  12:47:35');
INSERT INTO `visit` VALUES ('c2a339c8111e4978bb14b2ccd5d6273c', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  10:23:56');
INSERT INTO `visit` VALUES ('c3aa672aceb542b8b32ef8f8e167da81', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  13:11:30');
INSERT INTO `visit` VALUES ('c614a25578934310802b15a46babba1a', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  15:28:22');
INSERT INTO `visit` VALUES ('c7742d9ef6e4487dbab276f4e4788f39', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-23  19:31:52');
INSERT INTO `visit` VALUES ('cb32524c046a4ecb83ff0b2b8aaa2eb0', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  13:54:12');
INSERT INTO `visit` VALUES ('cba52f4e3a8543dd986e65c6a9566998', '0:0:0:0:0:0:0:1', '???', '2019-02-24  17:46:39');
INSERT INTO `visit` VALUES ('cbe5596c84a741f2afe631f5cc228d09', '0:0:0:0:0:0:0:1', 'admin', '2019-02-26  13:25:01');
INSERT INTO `visit` VALUES ('cf23fb1327d84606b441ee354fc75b0f', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  11:46:00');
INSERT INTO `visit` VALUES ('cfd3c7cbb8934703b597d5e83dd36487', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  12:52:25');
INSERT INTO `visit` VALUES ('d370458116344c039e678796e05c1241', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  12:48:43');
INSERT INTO `visit` VALUES ('dc17d4be3f484803b6b842aa0bddc5ab', '0:0:0:0:0:0:0:1', 'admin', '2019-02-26  13:28:50');
INSERT INTO `visit` VALUES ('dc7bb99033c04ac39716d51c584c7b88', '0:0:0:0:0:0:0:1', '???', '2019-02-21  17:45:17');
INSERT INTO `visit` VALUES ('de0626be4198430eab87eabcd5195478', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  16:06:55');
INSERT INTO `visit` VALUES ('debb6a7f7da045718a4607eeda420b5f', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-23  21:26:19');
INSERT INTO `visit` VALUES ('e06e868e27534a5fa82d2ed27ed096c7', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  14:19:00');
INSERT INTO `visit` VALUES ('e3e0e63735bc431fb07968b244b0587b', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  12:59:51');
INSERT INTO `visit` VALUES ('e5c286aa8f2e4922aa15ee8d9930289d', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  13:58:14');
INSERT INTO `visit` VALUES ('ea898a38ba1344188bc6deef19c8d83c', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  12:06:33');
INSERT INTO `visit` VALUES ('eb7d03c028084676b0b1e188055b5ab3', '0:0:0:0:0:0:0:1', '???', '2019-02-24  12:53:01');
INSERT INTO `visit` VALUES ('ef38ecf14cf1428d818e55ece16cd0a8', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  11:34:36');
INSERT INTO `visit` VALUES ('ef80520ee9674488a63714249af19fff', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  14:39:17');
INSERT INTO `visit` VALUES ('f088953e6dfb41fa8fd13630190f2ea3', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  12:55:22');
INSERT INTO `visit` VALUES ('f25a551076b3494d868ce15fc362310f', '0:0:0:0:0:0:0:1', 'admin', '2019-02-26  13:23:42');
INSERT INTO `visit` VALUES ('f5c545a9357748748ccb2bf4938bee4e', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  12:12:02');
INSERT INTO `visit` VALUES ('f9d183f9e64944fa80ae79b8f96e95e5', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  11:23:38');
INSERT INTO `visit` VALUES ('fadd94f8eeb94a51956306802a6bd4b2', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-24  12:12:46');
INSERT INTO `visit` VALUES ('ff6a02757b3a4faca464b13e57b09013', '0:0:0:0:0:0:0:1', 'Lxx', '2019-02-26  13:44:57');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
