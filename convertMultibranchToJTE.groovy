import org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject
import org.boozallen.plugins.jte.job.TemplateBranchProjectFactory

Jenkins.get().getItems().findAll{ it instanceof WorkflowMultiBranchProject }.each{ job -> 
  if( !(job.getProjectFactory() instanceof TemplateBranchProjectFactory) ){
    println "Noncompliant project: ${job.getFullName()}"
    println "Changing project to use JTE." 
    job.setProjectFactory(new TemplateBranchProjectFactory())
  }
}

Jenkins.get().save()
