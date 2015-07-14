/**
 * Created by katsiaryna.siamikina on 14.07.2015.
 */
var WaybillView = Backbone.View.extend( {


    el : $(Application.constants.PARTIAL_VIEW_SELECTOR),

    events : {
        "click #add-stock-item" : "addStockItem"
    },

    render : function(id) {

        var instance = this;
        Util.renderView(
            instance,
            "waybill",
            "resources/app/js/waybill/template/",
            ".html",
            {},
            undefined,
            function() {
                Util.renderViewAfter(
                    instance,
                    "stock-item",
                    "resources/app/js/waybill/template/",
                    ".html",
                    {},
                    undefined
                );
            }
        );
    },

    addStockItem : function() {

        Util.renderViewAfter(
            this,
            "stock-item",
            "resources/app/js/waybill/template/",
            ".html",
            {},
            undefined
        );
    }
});