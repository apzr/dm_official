// 百度地图API功能
var map = new BMap.Map("baiduMap"); // 创建Map实例
var point = new BMap.Point(113.906429, 35.275876);
map.centerAndZoom(point, 14);

map.setCurrentCity("河南"); // 设置地图显示的城市 此项是必须设置的
map.enableScrollWheelZoom(true); // 开启鼠标滚轮缩放

var marker = new BMap.Marker(point); // 创建标注
map.addOverlay(marker); // 将标注添加到地图中

var sContent = "<p style='font-size: 10px;'>河南省 新乡市 红旗区 <br/>20号街坊开祥天下城 3号楼1单元0101</p>";
var opts = {
	width : 280, // 信息窗口宽度
	height : 55, // 信息窗口高度
	title : "<FONT color='#3CC2FF'>新乡市开发区钉铆知识产权代理服务有限公司</FONT>", // 信息窗口标题
	enableMessage : false,// 设置允许信息窗发送短息
	message : ""
}
var infoWindow = new BMap.InfoWindow(sContent, opts); // 创建信息窗口对象
map.openInfoWindow(infoWindow, point); // 开启信息窗口

marker.addEventListener("click", function() {
	map.openInfoWindow(infoWindow, point); // 开启信息窗口
});
