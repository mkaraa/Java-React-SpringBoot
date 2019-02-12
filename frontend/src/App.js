import React, { Component } from 'react';
import './App.css';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';


class App extends Component {

		
		 constructor(props) {
			    super(props);
	            this.handleClickEdit = this.handleClickEdit.bind(this);
	            this.handleClickEditInstructors = this.handleClickEditInstructors.bind(this);
	            //this.handleClickAdd = this.handleClickAdd.bind(this);
		 }
		 

	    state = {
	    	      isLoading: true,
	    	      selected: false,
	    	      update: false,
	    	      addSchool: false,
	    	      addInstructor: false,
	    	      schools : [],
	    	      instructors : [],
	    		  selectedSchool: [],
	    		  selectedInstructor: []
    	    };
	    
	    emptlySchool = {
	    		
	    		schoolId: "",
	    		schoolPhone: "",
	    		schoolAddress: "",
	    		schoolName: ""
	    }
	    
 /******************************************************************************************************************************************************************************************/
	    //FETCH SCHOOLS
		  async componentDidMount() {
		    const response = await fetch('/api/school', {mode:"no-cors",  
		    	method: 'GET',
		    	headers: {
		      'Accept': 'application/json',
		      'Content-Type': 'application/json'
		  }}, );
		    const data = await response.json();
		    this.setState({ schools: data, isLoading: false, update: false });
		  }
		  
		  
		  
	      //FETCH INSTRUCTORS
		  async componentDidMount(){
			  const response = await fetch('api/instructor', {mode:"no-cors",
				  method:'GET',				 
				   headers : {
				  'Accept': 'application/json',
			      'Content-Type': 'application/json'
			  }}, );
			  const body = await response.json();
			  this.setState({instructors: body, isLoading: false, update: false})
		  }
		  
/******************************************************************************************************************************************************************************************/
	  //EDIT SCHOOL
	 async handleClickEdit(schoolId) {
			  console.log(schoolId);

			  await fetch('/api/school/{schoolId}', {mode: 'no-cors', 
				  method: 'PUT',
				  headers: {
					  'Accept': 'application/json',
					  'Content-Type': 'application/json'
				  },
			  })  .then(async(response) => {
			        this.setState({update: true,addSchool: false, selectedSchool: await response.json()});
			    });
			  };
	  
			  
	//EDIT INSTRUCTORS	
			  async handleClickEditInstructors(instructorId){
				  console.log(instructorId + " instructor ID");
				  
				  const response = await fetch("api/instructor/${instructorId}",{mode:"no-cors",
					  method:'GET',
					  headers:{
						  'Accept': 'application/json',
						  'Content-Type': 'application/json'
					  }},  ).then(() => {
					  const body =  response.json();
					  this.setState({selectedInstructor:body, isLoading:false, update:false, addInstructor: true });
				  });
			  };
/******************************************************************************************************************************************************************************************/
			  
     //REMOVE SCHOOL
	 async remove(schoolId) {
		 	console.log(schoolId + " is deleted.");
				    await fetch(`/api/school/${schoolId}`, {
				      method: 'DELETE',
				      headers: {
				        'Accept': 'application/json',
				        'Content-Type': 'application/json'
				      }
				    }).then(() => {
				      window.location.reload();
				    });
			}		
	 
	 //REMOVE INSTRUCTOR
	 async removeInstructor(instructorId) {
			 	console.log(instructorId + " is deleted.");
					    await fetch("api/instructor/${instructorId}", {
					      method: 'DELETE',
					      headers: {
					        'Accept': 'application/json',
					        'Content-Type': 'application/json'
					      }
					    }).then(() => {
					      window.location.reload();
					    });
				}
	 
/******************************************************************************************************************************************************************************************/
	 

     if(update){
   	  
   	  return 
   	  {selectedSchool.map(selectedSchool =>
   	  <form onSubmit={() => {this.handleUpdate(selectedSchool.schoolId)}}>
         <label htmlFor="schoolName">School Name</label>
         <input id="schoolName" name="schoolName" value="{selectedSchool.schoolName}" type="text" />

         <label htmlFor="schoolPhone">School Phone</label>
         <input id="schoolPhone" name="schoolPhone" value="{selectedSchool.schoolPhone}" type="text" />

         <label htmlFor="schoolAddress">School Address</label>
         <input id="schoolAddress" name="schoolAddress" value="{selectedSchool.schoolPhone}" type="text" />

         <button>Send data!</button>
       </form>
   	)};
   	  
     }
     
    /*
	if(addSchool){
	    	  
	    	  return 
	    	  {selectedSchool.map(selectedSchool =>
	    	  <form onSubmit={() => {this.handleUpdate(selectedSchool.schoolId)}}>
	          <label htmlFor="schoolName">School Name</label>
	          <input id="schoolName" name="schoolName" type="text" />
	
	          <label htmlFor="schoolPhone">School Phone</label>
	          <input id="schoolPhone" name="schoolPhone"  type="text" />
	
	          <label htmlFor="schoolAddress">School Address</label>
	          <input id="schoolAddress" name="schoolAddress"  type="text" />
	
	          <button>Send data!</button>
	        </form>
	    	)};
	    	  
	      }
     
     */
 /******************************************************************************************************************************************************************************************/
	  //RENDERING
	 render() {
      const {instructors,schools, isLoading, update, selectedSchool} = this.state;
      const {item} = this.state;
      console.log(schools + " - SCHOOL ARRAY");
      console.log(schools.map + " - SCHOOL MAP ");
      console.log(instructors + "- INSTRUCTOR ARRAY");
      console.log(instructors.map + " - INSTRUCTOR MAP");
            

      
      if (isLoading) {
        return <p>Loading...</p>;
      }
      

      return (
     <div class="divContainer">
    		  

          <table id="insTable">
            <thead id="borderTh">
              <tr>
                <th scope="col">Instructors Name</th>
                <th scope="col">Instructors Surname</th>
                <th scope="col">Instructors Branch</th>
                <th scope="col">Instructors Age</th>
                <th scope="col">Instructors Phone</th>
                <th scope="col">Instructors School</th>
                <th scope="col" colspan="3">Settings</th>
              </tr>
            </thead>
      <tbody>
            {instructors.map(instructor =>
              <tr id={instructor.instructorId}>
              	   <td>{instructor.instructorName} </td>
	               <td>{instructor.instructorSurname} </td>
	               <td>{instructor.instructorBranch}</td>
	               <td>{instructor.instructorAge}</td>
	               <td>{instructor.instructorPhone}</td>
	               <td>{instructor.instructorSchoolName}</td>
	              
	               <td>
              		<button onClick={() => {this.handleClickAddInstructor(instructor.instructorId)}}> Add </button>
              	   </td>
	               <td>
	               		<button onClick={() => {this.handleClickEditInstructors(instructor.instructorId)}}> Edit </button>
	               </td>
	               <td>
	               		<button onClick={() => {this.removeInstructor(instructor.instructorId)}}> Delete </button>
	               </td>
              </tr>
            )}
      </tbody>
    </table>

	
  	<table id="schoolTable">
          <thead>
            <tr>
              <th scope="col">School Name</th>
              <th scope="col">School Address</th>
              <th scope="col">School Phone</th>
              <th scope="col" colspan="3">Settings</th>
            </tr>
          </thead>
     <tbody>
          {schools.map(school =>
            <tr id={school.schoolId}>
	               <td>{school.schoolName} </td>
	               <td>{school.schoolAddress}</td>
	               <td>{school.schoolPhone}</td>
	               
	               <td>
               		<button onClick={() => {this.handleClickAdd(school.schoolId)}}> Add </button>
               </td>

	               <td>
	               		<button onClick={() => {this.handleClickEdit(school.schoolId)}}> Edit </button>
	               </td>
	               <td>
	               		<button onClick={() => {this.remove(school.schoolId)}}> Delete </button>
	               </td>

            </tr>
          )}
        </tbody>
  </table>
  
 
        </div>      
      );
    }

}

export default App;
