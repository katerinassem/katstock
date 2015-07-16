/**
 * Created by katsiaryna.siamikina on 08.07.2015.
 */

var Application = (function() {

    var Router = Backbone.Router.extend({

        routes : {
            "" : "home",
            "login" : "login",
            "stocks" : "stocks",
            "stock/:id" : "stock",
            "new-waybill/:id" : "newWaybill"
        },
        home : function() {

            ///render home view
            ViewsFactory.home().render();
        },
        login : function() {

            //render login view
            ViewsFactory.login().render();
        },
        stocks : function() {

            ViewsFactory.stocks().render();
        },
        stock : function(id) {

            ViewsFactory.stock().render(id);
        },
        newWaybill : function(id) {

            ViewsFactory.waybill().render(id);
        }
    });

    var Api = {

        init : function() {
            Api.router = new Router();
            Backbone.history.start();
            ViewsFactory.header().render();
        },

        constants : {
            PARTIAL_VIEW_SELECTOR : "#partial-view",
            HEADER_SELECTOR : "#header",
            PLACE_PICKER_SELECTOR : "#place-picker-content"
        },

        updateHeader : function() {
            ViewsFactory.header().render();
        }
    };

    return Api;

})();

window.onload = function() {
    Application.init();
};