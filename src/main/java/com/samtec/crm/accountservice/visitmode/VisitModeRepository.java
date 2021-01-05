
package com.samtec.crm.accountservice.visitmode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitModeRepository extends JpaRepository<VisitMode,Long> {
}
