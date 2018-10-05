$(function () {
	var projectName = window.document.location.pathname.split("/")[1];
	var initUrl = "/" + projectName + "/shop/getShopInitInfo";
	var registerShopUrl = "/" + projectName + "/shopAdmin/registerShop";
	getShopInitInfo();

	function getShopInitInfo() {
		$.getJSON(initUrl, function (data) {
			if (data.success) {
				var tempHtml = "";
				var tempAreaHtml = "";
				data.shopCategoryList.map(function (item, index) {
					tempHtml += '<option data-id="' + item.shopCategoryId + '">' + item.shopCategoryName + '</option>';
				})
				data.areaList.map(function (item, index) {
					tempAreaHtml += '<option data-id="' + item.areaId + '">' + item.areaName + '</option>';
				});
				$("#shopCategory").html(tempHtml);
				$("#area").html(tempAreaHtml);
			}
		});
		$("#submit").click(function () {
			var shop = {};
			shop.shopName = $("#shopName").val();
			shop.shopAddr = $("#shopAddr").val();
			shop.phone = $("#shopPhone").val();
			shop.shopDesc = $("#shopDesc").val();
			shop.shopCategory = {
				shopCategoryId: $("#shopCategory").find("option").not(function () {
					return !this.selected;
				}).data("id")
			};
			shop.area = {
				areaId: $("#area").find("option").not(function () {
					return !this.selected;
				}).data("id")
			};
			var shopImg = $("#shopImg")[0].files[0];
			var formData = new FormData();
			formData.append("shopImg", shopImg);
			formData.append("shopStr", JSON.stringify(shop));
			$.ajax({
				url: registerShopUrl,
				type: "post",
				data: formData,
				contentType: false,
				processData: false,
				cache: false,
				success: function (data) {
					if (data.success) {
						$.toast("提交成功");
					} else {
						$.toast("提交失败" + data.errMsg);
					}
				}
			});
		});
	}
});