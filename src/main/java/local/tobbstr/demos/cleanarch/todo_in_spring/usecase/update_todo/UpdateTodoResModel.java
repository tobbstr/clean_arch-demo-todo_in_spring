package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo;

public class UpdateTodoResModel {
	public String errMsg;
	
	public UpdateTodoResModel(String errMsg) {
		this.errMsg = errMsg;
	}
	
	public String getErrMsg() {
		return errMsg;
	}

}
