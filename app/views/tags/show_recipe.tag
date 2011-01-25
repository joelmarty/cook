*{ Display a recipe in short or full presentations }*

<div class="recipe ${_as == 'short' ? 'short' : 'full' }">
    <h2 class="recipe-title">
        <a href="#">${_recipe.title}</a>
    </h2>
    <div class="recipe-meta">
        <span class="recipe-author">by ${_recipe.author.name}</span>
        <span class="recipe-date"> on ${_recipe.date}</span>
    </div>
    <div class="recipe-content">
        #{if _as == 'short'}
            <div class="short-desc">
               ${_recipe.description.substring(0,300)} 
            </div>
        #{/if}
        #{if _as == 'full'}
            <div class="long-desc">
                ${_recipe.description}
            </div>
            <div class="recipe-ingredients">
                <ul class="ingredient-list">
                    #{list items:_recipe.ingredients, as:'ing'}
                        <li class="ingredient">${ing.name}</li>  
                    #{/list}
                </ul>
            </div>
            <div class="recipe-instructions">
                ${_recipe.instructions}
            </div>
        #{/if}
    </div>

</div>
