package octo.service

import octo.dao.IssueEventDAO
import octo.model.IssueEvent

class IssueEventService {

    private val issueEventDAO : IssueEventDAO = IssueEventDAO()

    fun createIssueEvent(issue: IssueEvent): IssueEvent {
        return this.issueEventDAO.insert(issue)
    }

    fun findByIssueId(issueId: Int): List<IssueEvent> {
        return this.issueEventDAO.getByIssueId(issueId)
    }
}