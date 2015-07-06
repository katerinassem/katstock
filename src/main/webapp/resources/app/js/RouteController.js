/**
 * Created by katsiaryna.siamikina on 06.07.2015.
 */
var Controller = Backbone.Router.extend({

    routes : {
        "" : "start", // Пустой hash-тэг
        "!/" : "start",
        "!/click" : "click"
    },

    start : function () {
    },

    click : function () {
        click.render();
    }
});

var controller = new Controller(); // Создаём контроллер

Backbone.history.start();  // Запускаем HTML5 History push