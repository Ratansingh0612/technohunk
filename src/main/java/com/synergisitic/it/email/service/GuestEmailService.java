package com.synergisitic.it.email.service;

import com.synergisitic.it.web.form.GuestUserForm;
import com.techquiz.codings.web.controller.vo.CodingProblmesLinkVO;

public interface GuestEmailService {
	public String sendTechTestEmailAsLink(GuestUserForm consultantsVO, String imageContextPath);

	public String sendCodingProblemEmailAsLink(CodingProblmesLinkVO coding, String imageContextPath);
}
