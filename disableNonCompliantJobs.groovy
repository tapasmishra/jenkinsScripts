import org.boozallen.plugins.jte.job.MultibranchTemplateFlowDefinition
import org.boozallen.plugins.jte.job.TemplateFlowDefinition

// maintain a list of jobs not using JTE
ArrayList noncompliantJobs = [] 

// set to true if you want to disable the noncompliant jobs
Boolean disableNoncompliant = false 

Jenkins.get().getAllItems().findAll{ it instanceof Job }.each{ job ->
  if( !(job.getDefinition().getClass() in [MultibranchTemplateFlowDefinition,TemplateFlowDefinition]) ){
    noncompliantJobs << job        
    job.setDisabled(disableNoncompliant)
  }
}

println "The following jobs are not using JTE: \n${noncompliantJobs.collect{ it.getFullName() }.join("\n")}"
