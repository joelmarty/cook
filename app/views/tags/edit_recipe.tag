*{ recipe edition page in create or edit mode }*

<div id="recipe ${ _as == 'create' ? 'create' : 'edit' }">
    <dl class="form_labels">
        *{ recipe title }*
        <dt class="label">Title:</dt>
        <dd><input id="title" type="text"/></dd>


    </dl>
</div>
