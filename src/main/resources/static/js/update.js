const form_element = document.getElementById('up1').elements;
for( let i=0 ; i < form_element.length; i++)
{
    form_element[i].disabled = true;
}
const enableForm=()=>{
    for( let i=0 ; i < form_element.length; i++)
    {
        form_element[i].disabled = false;
    }
}

document.getElementById('edit1').onclick=()=>{
    enableForm()
}