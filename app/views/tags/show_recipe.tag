*{ Display a recipe in short or full presentations }*
<div class="recipe ${_as == 'short' ? 'short' : 'full' }">
    #{if _as == 'short'}
        <h2 class="recipe-link">
            <a href="/recipes/${_recipe.id}">${_recipe.title}</a>
        </h2>
    #{/if}
    #{if _as == 'full'}
        <h2 class="recipe-title">${_recipe.title}</h2>
    #{/if}
    <div class="recipe-meta">
        <span class="recipe-author">by ${_recipe.author.name}</span>
        <span class="recipe-date"> on ${_recipe.date}</span>
    </div>
    <div class="recipe-content">
        #{if _as == 'short'}
            <div class="short-desc">
               ${_recipe.description} 
            </div>
        #{/if}
        #{if _as == 'full'}
            <div class="recipe-ingredients">
                <dl class="ingredient-list">
                    #{list items:_recipe.ingredients, as:'ing'}
                        <dt class="ingredient-title">${ing.ingredient.name}</dt>
                        <dd class="ingredient-qty">${ing.quantity}</dd>
                    #{/list}
                </dl>
            </div>
            <div class="recipe-instructions">
                ${_recipe.instructions}
            </div>
        #{/if}
    </div>

</div>
