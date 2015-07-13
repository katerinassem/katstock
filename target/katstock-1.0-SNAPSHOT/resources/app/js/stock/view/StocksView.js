/**
 * Created by katsiaryna.siamikina on 10.07.2015.
 */

var StocksView = Backbone.View.extend({

    el: $(Application.constants.PARTIAL_VIEW_SELECTOR),

    render: function () {

        this.stocks = new Stocks();

        var options = {
            error: function (data) {
                console.log(JSON.stringify(data));
            },
            success: function (data) {
                console.log(JSON.stringify(data));
            }
        };

        var instance = this;
        this.stocks.fetch(options)
            .always(function (data) {
                console.log(JSON.stringify(data));
                Util.renderView(
                    instance,
                    "stocks-list",
                    "resources/app/js/stock/template/",
                    ".html",
                    data,
                    "stocks"
                );
            });
    }
});