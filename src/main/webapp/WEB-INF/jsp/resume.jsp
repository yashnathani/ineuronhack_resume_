<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">


  <form:form method="post" modelAttribute="todo">
  <form:hidden path="id"/>
    <fieldset class="form-group">
     <form:label path="name">Name</form:label>
     <form:input path="name" type="text" class="form-control" required="required"/>
     <form:errors path="name" cssClass="text-warning"/>
  </fieldset>

<fieldset class="form-group">
     <form:label path="obj">Objective</form:label>
     <form:input path="obj" type="text" class="form-control" required="required"/>
     <form:errors path="obj" cssClass="text-warning"/>
  </fieldset>
  
  <fieldset class="form-group">
     <form:label path="proj">PROJECTS</form:label>
     <form:input path="proj" type="text" class="form-control" required="required"/>
     <form:errors path="proj" cssClass="text-warning"/>
  </fieldset>
  
  <fieldset class="form-group">
     <form:label path="skill">SKILLS</form:label>
     <form:input path="skill" type="text" class="form-control" required="required"/>
     <form:errors path="skill" cssClass="text-warning"/>
  </fieldset>
  
   <fieldset class="form-group">
     <form:label path="location">LOCATION</form:label>
     <form:input path="location" type="text" class="form-control" required="required"/>
     <form:errors path="location" cssClass="text-warning"/>
  </fieldset>
  
   <fieldset class="form-group">
     <form:label path="regards">REGARDS</form:label>
     <form:input path="regards" type="text" class="form-control" required="required"/>
     <form:errors path="regards" cssClass="text-warning"/>
  </fieldset>

 <button type="submit" class="btn btn-success">Save</button>



</form:form>


 </div>
 <%@ include file="common/footer.jspf" %>