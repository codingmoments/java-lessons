package cloning.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Task implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long taskId;
  private String summary;
  private String description;
  private LocalDate createdDate;
  private LocalDate completedDate;

  public Task() {
  }

  public Task(Task task) {
    this.taskId = task.getTaskId();
    this.summary = task.getSummary();
    this.description = task.getDescription();
    this.createdDate = task.getCreatedDate();
    this.completedDate = task.getCompletedDate();
  }

  public Long getTaskId() {
    return taskId;
  }

  public void setTaskId(Long taskId) {
    this.taskId = taskId;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = createdDate;
  }

  public LocalDate getCompletedDate() {
    return completedDate;
  }

  public void setCompletedDate(LocalDate completedDate) {
    this.completedDate = completedDate;
  }

  public boolean deepEquals(Object obj) {
    // Unlike equals(), if both references point to same object, we return false.
    if (this == obj)
      return false;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Task other = (Task) obj;
    return Objects.equals(completedDate, other.completedDate) && Objects.equals(createdDate, other.createdDate) && Objects.equals(description, other.description)
      && Objects.equals(summary, other.summary) && Objects.equals(taskId, other.taskId);
  }

}
