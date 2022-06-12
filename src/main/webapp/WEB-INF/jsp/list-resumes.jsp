<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
 <table class="table table-striped">
 <caption> Saved Resumes are  </caption>
 <thead>
       <tr>
            <th>Name</th>
             <th>Objective</th>
               <th>Project</th>
               <th>Skills</th>
               <th>Location</th>
               <th>Regards</th>
               <th>  </th>
               <th>  </th> 
       </tr>
 </thead>
 <tbody>
 <c:forEach items="${todos}" var="todo">
  <tr>
           <td>${todo.name}</td>
           <td>${todo.obj}</td>
           <td> ${todo.proj}</td>
           <td>${todo.skill}</td>
           <td>${todo.location}</td>
           <td>${todo.regards}</td>
           
           <td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">Update</a></td>
           <td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete</a></td>
       </tr>
 
 
 </c:forEach>
     
 
 </tbody>
 </table>
 <div> <a class="button" href="/add-todo">save any resume</a></div>
 
 
 <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
 <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 </div>
 <%@ include file="common/footer.jspf" %>