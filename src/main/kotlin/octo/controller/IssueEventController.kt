package octo.controller

import octo.model.IssueEvent
import octo.service.IssueEventService

class IssueEventController {

    private val issueEventService : IssueEventService = IssueEventService()

    fun createIssueEvent(issue: IssueEvent): IssueEvent {
        return this.issueEventService.createIssueEvent(issue)
    }

    fun findByIssueId(issueId: Int): List<IssueEvent> {
        return this.issueEventService.findByIssueId(issueId)
    }
}