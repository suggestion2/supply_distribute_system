<#list list as item>
    name : ${item.name}
    status : ${item.status}
    <#list item.list as item1>
        name1 : ${item1.name}
        status1 : ${item1.status}
        <#list item1.list as item2>
            name2 : ${item2.name}
            status2 : ${item2.status}
        </#list>
    </#list>
</#list>