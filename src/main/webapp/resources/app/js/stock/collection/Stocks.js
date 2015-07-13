/**
 * Created by katsiaryna.siamikina on 10.07.2015.
 */
var Stocks = Backbone.Collection.extend({

    url: function () {
        return "stocks";
    },

    model: Stock,

    modelId: function () {
        return "stockId";
    },

    toJSON: function () {
        return this.map(function (model) {
            return model.toJSON();
        });
    }
});