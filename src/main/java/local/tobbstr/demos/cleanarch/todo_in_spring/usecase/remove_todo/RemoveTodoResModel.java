package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo;

public class RemoveTodoResModel {
	public String errMsg;
	
	public RemoveTodoResModel(String errMsg) {
		this.errMsg = errMsg;
	}
	
	public String getErrMsg() {
		return errMsg;
	}
}
