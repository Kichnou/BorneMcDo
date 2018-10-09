$(document).ready(function() {
    $("#menu a").click(function() {
        page = "/WEB-INF/"+$(this).attr("href");
        afficher(page);
        return false;
    });
    
});

function afficher(data){
    $("#contenu").empty();
    $("#contenu").load(data);
}