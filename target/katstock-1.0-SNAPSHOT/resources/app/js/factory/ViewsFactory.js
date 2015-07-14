/**
 * Created by katsiaryna.siamikina on 13.07.2015.
 */
var ViewsFactory = (function() {
    return {

        header : function () {
            return new HeaderView();
        },
        home : function () {
            return new HomeView();
        },
        login : function () {
            return new LoginView();
        },
        stocks : function () {
            return new StocksView();
        },
        stock : function() {
            return new StockView();
        },
        waybill : function() {
            return new WaybillView();
        }
    };
})();