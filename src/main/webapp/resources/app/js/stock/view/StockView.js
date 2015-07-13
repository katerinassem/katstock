/**
 * Created by katsiaryna.siamikina on 13.07.2015.
 */
var StockView = Backbone.View.extend( {

    el : $(Application.constants.PARTIAL_VIEW_SELECTOR),

    render : function(id) {

        this.stock = new Stock({
            "stockId" : id
        });

        var options = {
            error: function (data) {
                console.log(JSON.stringify(data));
            },
            success: function (data) {
                console.log(JSON.stringify(data));
            }
        };

        var instance = this;
        this.stock.fetch(options)
            .always(function (data) {
                console.log(JSON.stringify(data));
                Util.renderView(
                    instance,
                    "stock",
                    "resources/app/js/stock/template/",
                    ".html",
                    data,
                    "stock"
                );
            });
    }
});